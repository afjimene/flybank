package com.flybank.clients.services;

import com.flybank.clients.entities.Client;
import com.flybank.clients.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client createClient(Client client) {
        // TODO: Validar la fecha de nacimiento
        if (repository.findByIdTypeAndIdNumber(client.getIdType(), client.getIdNumber()).isPresent())
            throw new RuntimeException("Client already exist.");
        return this.repository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        var optionalClient = repository.findByIdTypeAndIdNumber(client.getIdType(), client.getIdNumber());
        if (optionalClient.isPresent() && !optionalClient.get().getId().equals(client.getId()))
            throw new RuntimeException("Client already exist with other id.");
        return this.repository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        // TODO: validar si tiene productos
        this.repository.deleteById(id);
    }

    @Override
    public Client getById(Long id) {
        return this.repository.getReferenceById(id);
    }
}

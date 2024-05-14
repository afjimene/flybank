package com.flybank.clients.services;

import com.flybank.clients.entities.Client;
import com.flybank.clients.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;
    private final ProductsGateway gateway;

    public ClientServiceImpl(ClientRepository repository, ProductsGateway gateway) {
        this.repository = repository;
        this.gateway = gateway;
    }

    @Override
    public Client createClient(Client client) {
        var years = Period.between(client.getBirthDate(), LocalDate.now()).getYears();
        if (years < 18)
            throw new RuntimeException("Client cannot be under-age.");
        if (repository.findByIdTypeAndIdNumber(client.getIdType(), client.getIdNumber()).isPresent())
            throw new RuntimeException("Client already exist.");
        return this.repository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        var years = Period.between(client.getBirthDate(), LocalDate.now()).getYears();
        if (years < 18)
            throw new RuntimeException("Client cannot be under-age.");
        var optionalClient = repository.findByIdTypeAndIdNumber(client.getIdType(), client.getIdNumber());
        if (optionalClient.isPresent() && !optionalClient.get().getId().equals(client.getId()))
            throw new RuntimeException("Client already exist with other id.");
        return this.repository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        var productsResponse = gateway.getProductsResponse(id);
        if (!productsResponse.getProducts().isEmpty())
            throw new RuntimeException("Client cannot be removed because have products");
        this.repository.deleteById(id);
    }

    @Override
    public Client getById(Long id) {
        return this.repository.getReferenceById(id);
    }
}

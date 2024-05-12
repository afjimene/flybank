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
        return this.repository.save(client);
    }
}

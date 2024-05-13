package com.flybank.clients.services;

import com.flybank.clients.entities.Client;

public interface ClientService {

    Client createClient(Client client);
    Client updateClient(Client client);
    void deleteClient(Long id);
    Client getById(Long id);
}

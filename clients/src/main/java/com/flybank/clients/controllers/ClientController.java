package com.flybank.clients.controllers;

import com.flybank.clients.api.handler.ClientApi;
import com.flybank.clients.api.model.Client;
import com.flybank.clients.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<Client> createClient(Client body) {
        //Map body to client entity
        //var client = clientService.createClient(body);
        //Map response to client api
        return null;
    }
}

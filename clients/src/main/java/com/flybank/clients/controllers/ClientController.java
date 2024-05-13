package com.flybank.clients.controllers;

import com.flybank.clients.api.handler.ClientApi;
import com.flybank.clients.api.model.CreateClient;
import com.flybank.clients.api.model.UpdateClient;
import com.flybank.clients.mapper.ClientMapper;
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
    public ResponseEntity<CreateClient> createClient(CreateClient body) {
        //Map body to client entity
        var client = clientService.createClient(ClientMapper.INSTANCE.createClientToClientDto(body));
        //Map response to client api
        return ResponseEntity.ok(ClientMapper.INSTANCE.clientDtoToCreateClient(client));
    }

    @Override
    public ResponseEntity<UpdateClient> updateClient(UpdateClient body) {
        //Map body to client entity
        var client = clientService.updateClient(ClientMapper.INSTANCE.updateClientToClientDto(body));
        //Map response to client api
        return ResponseEntity.ok(ClientMapper.INSTANCE.clientDtoToUpdateClient(client));
    }
}

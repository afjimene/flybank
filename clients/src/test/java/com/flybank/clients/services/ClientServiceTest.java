package com.flybank.clients.services;

import com.flybank.clients.entities.Client;
import com.flybank.clients.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ClientServiceTest {

    @Autowired
    ClientService clientService;

    @MockBean
    ClientRepository repository;

    @Test
    void ClientService_CreateClient_ReturnsClientDto() {
        var client = new Client();
        client.setId(12345L);
        client.setNames("test1");
        client.setBirthDate(LocalDate.of(1980,2,16));

        given(repository.save(Mockito.any(Client.class))).willReturn(client);

        var savedClient = clientService.createClient(client);

        assertNotNull(savedClient);
        assertEquals(12345L, savedClient.getId());
        assertEquals("test1", savedClient.getNames());
    }
}

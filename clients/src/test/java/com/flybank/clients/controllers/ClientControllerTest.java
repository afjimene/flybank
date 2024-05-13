package com.flybank.clients.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flybank.clients.api.model.CreateClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void createClientTestWithMockMvc(@Autowired MockMvc mvc) throws Exception {
        var client = new CreateClient();
        client.setIdNumber("1231234");
        client.setIdType("1");
        client.setNames("test1");
        client.setSurnames("test2");
        client.setEmail("test@test.com");
        client.setBirthDate("19800101");

        mvc.perform(MockMvcRequestBuilders
                .post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(client)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.names").value("test1"));
    }
}

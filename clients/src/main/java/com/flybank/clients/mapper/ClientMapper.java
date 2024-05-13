package com.flybank.clients.mapper;

import com.flybank.clients.api.model.CreateClient;
import com.flybank.clients.api.model.UpdateClient;
import com.flybank.clients.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );

    Client createClientToClientDto(CreateClient client);
    CreateClient clientDtoToCreateClient(Client client);
    Client updateClientToClientDto(UpdateClient client);
    UpdateClient clientDtoToUpdateClient(Client client);

}

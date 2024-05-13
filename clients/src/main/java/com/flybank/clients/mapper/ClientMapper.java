package com.flybank.clients.mapper;

import com.flybank.clients.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper( ClientMapper.class );

    Client clientToClientDto(com.flybank.clients.api.model.Client client);
    com.flybank.clients.api.model.Client clientDtoToClient(Client client);

}

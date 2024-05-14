package com.flybank.transactions.mapper;

import com.flybank.transactions.entities.Transaction;
import com.flybank.transactions.json.TransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper( TransactionMapper.class );

    Transaction map(com.flybank.transactions.api.model.Transaction transaction);
    TransactionRequest map(Transaction transaction);
}

package com.flybank.transactions.services;

import com.flybank.transactions.json.TransactionRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface ProductsGateway {

    @PostExchange("/service-api/transaction")
    void updateBalances(@RequestBody TransactionRequest transaction);
}

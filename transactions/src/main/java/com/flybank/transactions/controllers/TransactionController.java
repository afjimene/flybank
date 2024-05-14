package com.flybank.transactions.controllers;

import com.flybank.transactions.api.handler.TransactionApi;
import com.flybank.transactions.api.model.Transaction;
import com.flybank.transactions.mapper.TransactionMapper;
import com.flybank.transactions.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController implements TransactionApi {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<Void> createTransaction(Transaction body) {
        transactionService.createTransaction(TransactionMapper.INSTANCE.map(body));
        return ResponseEntity.ok().build();
    }
}

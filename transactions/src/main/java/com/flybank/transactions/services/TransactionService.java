package com.flybank.transactions.services;

import com.flybank.transactions.entities.Transaction;

public interface TransactionService {

    void createTransaction(Transaction transaction);
}

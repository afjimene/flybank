package com.flybank.transactions.services;

import com.flybank.transactions.entities.Transaction;
import com.flybank.transactions.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        this.repository.save(transaction);
    }
}

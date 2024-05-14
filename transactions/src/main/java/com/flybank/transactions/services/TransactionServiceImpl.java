package com.flybank.transactions.services;

import com.flybank.transactions.entities.Transaction;
import com.flybank.transactions.mapper.TransactionMapper;
import com.flybank.transactions.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;
    private final ProductsGateway gateway;

    public TransactionServiceImpl(TransactionRepository repository, ProductsGateway gateway) {
        this.repository = repository;
        this.gateway = gateway;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        gateway.updateBalances(TransactionMapper.INSTANCE.map(transaction));
        this.repository.save(transaction);
    }
}

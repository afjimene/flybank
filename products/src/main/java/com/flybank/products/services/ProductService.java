package com.flybank.products.services;

import com.flybank.products.entities.Product;
import com.flybank.products.service.api.model.Transaction;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getProductByClient(Long clientId);
    void activateProduct(Long accountNumber);
    void deactivateProduct(Long accountNumber);
    void cancelProduct(Long accountNumber);
    void updateBalance(Transaction transaction);
}

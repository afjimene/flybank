package com.flybank.products.repository;

import com.flybank.products.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByClientId(Long clientId);
    Product findByAccountNumber(Long accountNumber);
}

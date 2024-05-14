package com.flybank.products.services;

import com.flybank.products.entities.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getProductByClient(Integer clientId);
}

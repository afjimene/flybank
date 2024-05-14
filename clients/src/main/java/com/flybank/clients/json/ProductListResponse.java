package com.flybank.clients.json;

import java.util.List;

public class ProductListResponse {
    public List<Products> products;

    public record Products(Long id, String accountType, String accountNumber){}

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}

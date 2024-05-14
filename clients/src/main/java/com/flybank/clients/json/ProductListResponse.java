package com.flybank.clients.json;

import java.math.BigDecimal;
import java.util.List;

public class ProductListResponse {
    public List<Products> products;

    public record Products(String accountType, String accountNumber, BigDecimal balance){}

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }
}

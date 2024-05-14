package com.flybank.clients.services;

import com.flybank.clients.json.ProductListResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ProductsGateway {

    @GetExchange("/service-api/productsByClient/{clientId})")
    ProductListResponse getProductsResponse(@PathVariable Long clientId);
}

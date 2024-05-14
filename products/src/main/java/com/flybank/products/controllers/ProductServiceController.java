package com.flybank.products.controllers;

import com.flybank.products.mapper.ProductMapper;
import com.flybank.products.service.api.handler.ServiceApiApi;
import com.flybank.products.service.api.model.ProductListResponse;
import com.flybank.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceController implements ServiceApiApi {

    private final ProductService productService;

    public ProductServiceController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<ProductListResponse> getProductsByClientId(Integer clientId) {
        var response = new ProductListResponse();
        response.setProducts(ProductMapper.INSTANCE.map(productService.getProductByClient(clientId)));
        return ResponseEntity.ok(response);
    }
}

package com.flybank.products.controllers;

import com.flybank.products.api.handler.ProductApi;
import com.flybank.products.api.model.Product;
import com.flybank.products.mapper.ProductMapper;
import com.flybank.products.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Void> activateProductsByAccountNumber(Long accountNumber) {
        productService.activateProduct(accountNumber);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> cancelProductsByAccountNumber(Long accountNumber) {
        productService.cancelProduct(accountNumber);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Product> createProduct(Product body) {
        //Map body to product entity
        var createProduct = ProductMapper.INSTANCE.productToProductDto(body);
        var product = productService.createProduct(createProduct);
        //Map response to product api
        return ResponseEntity.ok(ProductMapper.INSTANCE.productDtoToProduct(product));
    }

    @Override
    public ResponseEntity<Void> deactivateProductsByAccountNumber(Long accountNumber) {
        productService.deactivateProduct(accountNumber);
        return ResponseEntity.ok().build();
    }
}

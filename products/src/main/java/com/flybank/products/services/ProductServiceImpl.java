package com.flybank.products.services;

import com.flybank.products.entities.Product;
import com.flybank.products.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final Random random = new Random();

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product createProduct(Product product) {
        //initialize the product with balance zero
        product.setBalance(new BigDecimal(0));
        switch (product.getAccountType()) {
            case SAVING -> product.setAccountNumber("53" + (10000000 + random.nextInt(90000000)));
            case CURRENT -> product.setAccountNumber("33" + (10000000 + random.nextInt(90000000)));
            default -> throw new RuntimeException("Invalid Account Type");
        }
        product.setStatus(Product.Status.ACTIVE);
        return this.repository.save(product);
    }

    @Override
    public List<Product> getProductByClient(Integer clientId) {
        return this.repository.findByClientId(clientId);
    }
}

package com.flybank.products.services;

import com.flybank.products.entities.Product;
import com.flybank.products.repository.ProductRepository;
import com.flybank.products.service.api.model.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        var accountNumber = 10000000L + random.nextLong(90000000L);
        switch (product.getAccountType()) {
            case SAVING -> product.setAccountNumber(5300000000L + accountNumber);
            case CURRENT -> product.setAccountNumber(3300000000L + accountNumber);
            default -> throw new RuntimeException("Invalid Account Type");
        }
        product.setStatus(Product.Status.ACTIVE);
        return this.repository.save(product);
    }

    @Override
    public List<Product> getProductByClient(Long clientId) {
        return this.repository.findByClientId(clientId);
    }

    @Override
    public void activateProduct(Long accountNumber) {
        var product = this.repository.findByAccountNumber(accountNumber);
        product.setStatus(Product.Status.ACTIVE);
        this.repository.save(product);
    }

    @Override
    public void deactivateProduct(Long accountNumber) {
        var product = this.repository.findByAccountNumber(accountNumber);
        product.setStatus(Product.Status.INACTIVE);
        this.repository.save(product);
    }

    @Override
    public void cancelProduct(Long accountNumber) {
        var product = this.repository.findByAccountNumber(accountNumber);
        if (BigDecimal.ZERO.compareTo(product.getBalance()) != 0)
            throw new RuntimeException("You cannot cancel an account if their balance is not zero");
        product.setStatus(Product.Status.CANCELED);
        this.repository.save(product);
    }

    @Override
    public void updateBalance(Transaction transaction) {
        var product = this.repository.findByAccountNumber(transaction.getAccountNumber());
        switch (transaction.getTransactionType()) {
            case "DEPOSIT":
                product.setBalance(product.getBalance().add(transaction.getAmount()));
                this.repository.save(product);
                break;
            case "WITHDRAWAL":
                if (Product.AccountType.SAVING.equals(product.getAccountType()) &&
                    product.getBalance().compareTo(transaction.getAmount()) < 0)
                    throw new RuntimeException("There is no enought balance");
                product.setBalance(product.getBalance().subtract(transaction.getAmount()));
                this.repository.save(product);
                break;
            case "TRANSFER":
                if (Product.AccountType.SAVING.equals(product.getAccountType()) &&
                        product.getBalance().compareTo(transaction.getAmount()) < 0)
                    throw new RuntimeException("There is no enought balance");
                var targetProduct = this.repository.findByAccountNumber(transaction.getTargetAccount());
                product.setBalance(product.getBalance().subtract(transaction.getAmount()));
                targetProduct.setBalance(targetProduct.getBalance().add(transaction.getAmount()));
                List<Product> products = new ArrayList<>();
                products.add(product);
                products.add(targetProduct);
                this.repository.saveAll(products);
                break;
            default:
                throw new RuntimeException("Transaction type not supported");
        }
    }
}

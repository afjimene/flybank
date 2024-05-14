package com.flybank.transactions;

import com.flybank.transactions.services.ProductsGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

	@Bean
	public ProductsGateway productsGateway() {
		WebClient client = WebClient.create("http://localhost:8082");
		HttpServiceProxyFactory factory =
				HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
		return factory.createClient(ProductsGateway.class);
	}
}

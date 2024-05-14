package com.flybank.clients;

import com.flybank.clients.services.ProductsGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class ClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}

	@Bean
	public ProductsGateway productsGateway() {
		WebClient client = WebClient.create("http://localhost:8082");
		HttpServiceProxyFactory factory =
				HttpServiceProxyFactory.builderFor(WebClientAdapter.create(client)).build();
		return factory.createClient(ProductsGateway.class);
	}
}

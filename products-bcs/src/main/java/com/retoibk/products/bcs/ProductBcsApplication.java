package com.retoibk.products.bcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class ProductBcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductBcsApplication.class, args);
	}

}

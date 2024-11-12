package com.retoibk.customer.products.bff.adapter.config.clients.web.client;

import com.retoibk.customer.products.bff.domain.exceptions.CustomerNotFoundException;
import com.retoibk.customer.products.bff.domain.request.RequestProductsClientDTO;
import com.retoibk.customer.products.bff.domain.response.ProductsClientResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.retoibk.customer.products.bff.domain.constants.CustomerProductsConstants.PRODUCTS_BASE_URL;
import static com.retoibk.customer.products.bff.domain.constants.CustomerProductsConstants.PRODUCTS_NOT_FOUND_MESSAGE;

@Service
public class ProductsServiceClient {

    private final WebClient productsWebClient;

    public ProductsServiceClient(WebClient.Builder webClientBuilder) {
        this.productsWebClient = webClientBuilder.baseUrl(System.getenv(PRODUCTS_BASE_URL)).build();
    }

    public Flux<ProductsClientResponseDTO> getCustomerProducts(String uniqueCode) {
        return productsWebClient.post()
                .uri("/products", uniqueCode)
                .bodyValue(new RequestProductsClientDTO(uniqueCode))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> switch (response.statusCode().value()){
                    case 404 -> Mono.error(new CustomerNotFoundException(PRODUCTS_NOT_FOUND_MESSAGE));
                    case 400 -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST));
                    default -> Mono.error(new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE));
                })
                .bodyToFlux(ProductsClientResponseDTO.class);
    }
}

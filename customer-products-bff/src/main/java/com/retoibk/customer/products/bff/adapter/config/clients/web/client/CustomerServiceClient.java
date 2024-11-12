package com.retoibk.customer.products.bff.adapter.config.clients.web.client;

import com.retoibk.customer.products.bff.domain.exceptions.CustomerNotFoundException;
import com.retoibk.customer.products.bff.domain.request.RequestCustomerClientDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerListResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.retoibk.customer.products.bff.domain.constants.CustomerProductsConstants.CUSTOMER_BASE_URL;
import static com.retoibk.customer.products.bff.domain.constants.CustomerProductsConstants.CUSTOMER_NOT_FOUND_MESSAGE;

@Service
public class CustomerServiceClient {
    private final WebClient customerWebClient;

    public CustomerServiceClient(WebClient.Builder webClientBuilder) {
        this.customerWebClient = webClientBuilder.baseUrl(System.getenv(CUSTOMER_BASE_URL)).build();
    }

    public Flux<CustomerListResponseDTO> getCustomerList() {
        return customerWebClient.get()
                .uri("/list")
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> switch (response.statusCode().value()){
                            default -> Mono.error(new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE));
                        })
                .bodyToFlux(CustomerListResponseDTO.class);
    }

    public Mono<CustomerClientResponseDTO> getCustomerData(String uniqueCode) {
        return customerWebClient.post()
                .uri("/customer", uniqueCode)
                .bodyValue(new RequestCustomerClientDTO(uniqueCode))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> switch (response.statusCode().value()){
                    case 404 -> Mono.error(new CustomerNotFoundException(CUSTOMER_NOT_FOUND_MESSAGE));
                    case 400 -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST));
                    default -> Mono.error(new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE));
                })
                .bodyToMono(CustomerClientResponseDTO.class);
    }
}

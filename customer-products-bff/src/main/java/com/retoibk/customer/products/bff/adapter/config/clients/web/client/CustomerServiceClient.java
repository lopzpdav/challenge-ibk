package com.retoibk.customer.products.bff.adapter.config.clients.web.client;

import com.retoibk.customer.products.bff.domain.exceptions.CustomerNotFoundException;
import com.retoibk.customer.products.bff.domain.request.RequestCustomerClientDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static com.retoibk.customer.products.bff.domain.constants.CustomerProductsConstants.CUSTOMER_NOT_FOUND_MESSAGE;

@Service
public class CustomerServiceClient {
    private final WebClient customerWebClient;

    public CustomerServiceClient(WebClient.Builder webClientBuilder) {
        this.customerWebClient = webClientBuilder.baseUrl("http://localhost:8081/api/v1").build();
    }

    public Mono<CustomerClientResponseDTO> getCustomerData(Long customerId) {
        return customerWebClient.post()
                .uri("/customer", customerId)
                .bodyValue(new RequestCustomerClientDTO(customerId))
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> switch (response.statusCode().value()){
                            case 404 -> Mono.error(new CustomerNotFoundException(String.format(CUSTOMER_NOT_FOUND_MESSAGE, customerId)));
                            case 400 -> Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST));
                            default -> Mono.error(new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE));
                        })
                .bodyToMono(CustomerClientResponseDTO.class);
    }
}

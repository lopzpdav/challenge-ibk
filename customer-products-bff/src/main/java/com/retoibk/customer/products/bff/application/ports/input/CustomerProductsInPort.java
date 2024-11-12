package com.retoibk.customer.products.bff.application.ports.input;

import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerListResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerProductsResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerProductsInPort {
    Flux<CustomerListResponseDTO> getCustomerList();
    Mono<CustomerProductsResponseDTO> getCustomerProducts(String id);
}

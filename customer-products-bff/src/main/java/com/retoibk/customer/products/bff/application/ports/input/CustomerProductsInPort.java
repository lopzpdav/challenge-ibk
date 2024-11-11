package com.retoibk.customer.products.bff.application.ports.input;

import com.retoibk.customer.products.bff.domain.response.CustomerProductsResponseDTO;
import reactor.core.publisher.Mono;

public interface CustomerProductsInPort {
    Mono<CustomerProductsResponseDTO> getCustomerProducts(Long id);
}

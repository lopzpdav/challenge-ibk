package com.retoibk.customer.products.bff.application.ports.output;

import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.ProductsClientResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerProductsOutPort {
    Mono<CustomerClientResponseDTO> getCustomerData(Long uniqueCode);
    Flux<ProductsClientResponseDTO> getCustomerProducts(Long uniqueCode);
}

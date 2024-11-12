package com.retoibk.customer.products.bff.application.ports.output;

import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerListResponseDTO;
import com.retoibk.customer.products.bff.domain.response.ProductsClientResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerProductsOutPort {
    Flux<CustomerListResponseDTO> getCustomerList();
    Mono<CustomerClientResponseDTO> getCustomerData(String uniqueCode);
    Flux<ProductsClientResponseDTO> getCustomerProducts(String uniqueCode);
}

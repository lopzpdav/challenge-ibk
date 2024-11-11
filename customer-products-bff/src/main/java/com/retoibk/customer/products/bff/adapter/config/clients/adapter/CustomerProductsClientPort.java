package com.retoibk.customer.products.bff.adapter.config.clients.adapter;

import com.retoibk.customer.products.bff.adapter.config.clients.web.client.CustomerServiceClient;
import com.retoibk.customer.products.bff.adapter.config.clients.web.client.ProductsServiceClient;
import com.retoibk.customer.products.bff.application.ports.output.CustomerProductsOutPort;
import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.ProductsClientResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CustomerProductsClientPort implements CustomerProductsOutPort {
    private final CustomerServiceClient customerServiceClient;
    private final ProductsServiceClient productsServiceClient;

    @Override
    public Mono<CustomerClientResponseDTO> getCustomerData(Long uniqueCode) {
        return customerServiceClient.getCustomerData(uniqueCode);
    }

    @Override
    public Flux<ProductsClientResponseDTO> getCustomerProducts(Long uniqueCode) {
        return productsServiceClient.getCustomerProducts(uniqueCode);
    }
}

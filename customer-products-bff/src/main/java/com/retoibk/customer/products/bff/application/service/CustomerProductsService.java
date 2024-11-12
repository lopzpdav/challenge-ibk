package com.retoibk.customer.products.bff.application.service;

import com.retoibk.customer.products.bff.application.ports.input.CustomerProductsInPort;
import com.retoibk.customer.products.bff.application.ports.output.CustomerProductsOutPort;
import com.retoibk.customer.products.bff.domain.mapper.CustomerProductsMapper;
import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerListResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerProductsResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerProductsService implements CustomerProductsInPort {

    private final CustomerProductsOutPort customerProductsOutPort;
    private final CustomerProductsMapper customerProductsMapper;

    @Override
    public Flux<CustomerListResponseDTO> getCustomerList() {
        return customerProductsOutPort.getCustomerList();
    }

    @Override
    public Mono<CustomerProductsResponseDTO> getCustomerProducts(String id) {
        return customerProductsOutPort.getCustomerData(id)
                .flatMap(customerData ->
                        customerProductsOutPort.getCustomerProducts(id)
                                .collectList()
                                .map(productsList -> customerProductsMapper.toResponseDTO(customerData, productsList))
                );
    }
}

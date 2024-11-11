package com.retoibk.products.bcs.adapter.repository;

import com.retoibk.products.bcs.adapter.entities.Product;
import com.retoibk.products.bcs.application.ports.output.DatabaseOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class ProductDatabaseOutPort implements DatabaseOutPort {

    private final ProductRepository productRepository;

    @Override
    public Flux<Product> getProducts(Long customerId) {
        return productRepository.findAllByCustomerId(customerId);
    }
}

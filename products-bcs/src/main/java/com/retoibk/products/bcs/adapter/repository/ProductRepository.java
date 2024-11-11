package com.retoibk.products.bcs.adapter.repository;

import com.retoibk.products.bcs.adapter.entities.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends R2dbcRepository<Product, Long> {
    Flux<Product> findAllByCustomerId(Long id);
}

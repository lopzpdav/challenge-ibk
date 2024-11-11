package com.retoibk.customer.bcs.adapter.repository;

import com.retoibk.customer.bcs.adapter.entities.Customer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends R2dbcRepository<Customer, Long> {
    Mono<Customer> findById(Long id);
}

package com.retoibk.customer.bcs.adapter.repository;

import com.retoibk.customer.bcs.adapter.entities.Customer;
import com.retoibk.customer.bcs.application.ports.output.DatabaseOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CustomerDatabaseOutPort implements DatabaseOutPort {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<Customer> getCustomer(Long customerId) {
        return customerRepository.findById(customerId);
    }
}

package com.retoibk.customer.bcs.application.ports.output;

import com.retoibk.customer.bcs.adapter.entities.Customer;
import reactor.core.publisher.Mono;

public interface DatabaseOutPort {
    Mono<Customer> getCustomer(Long customerId);
}

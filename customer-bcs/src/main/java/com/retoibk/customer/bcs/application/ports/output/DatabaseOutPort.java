package com.retoibk.customer.bcs.application.ports.output;

import com.retoibk.customer.bcs.adapter.entities.Customer;
import com.retoibk.customer.bcs.domain.response.CustomerListResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DatabaseOutPort {
    Flux<Customer> getCustomerList();
    Mono<Customer> getCustomer(Long customerId);
}

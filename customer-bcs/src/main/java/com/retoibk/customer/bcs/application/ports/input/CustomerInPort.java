package com.retoibk.customer.bcs.application.ports.input;

import com.retoibk.customer.bcs.domain.response.CustomerListResponseDTO;
import com.retoibk.customer.bcs.domain.response.CustomerListResponseEncryptedDTO;
import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerInPort {
    Flux<CustomerListResponseEncryptedDTO> getCustomerList();
    Mono<CustomerResponseDTO> getCustomerDetails(String id);
}

package com.retoibk.customer.bcs.application.ports.input;

import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
import reactor.core.publisher.Mono;

public interface CustomerInPort {
    Mono<CustomerResponseDTO> getCustomerDetails(Long id);
}

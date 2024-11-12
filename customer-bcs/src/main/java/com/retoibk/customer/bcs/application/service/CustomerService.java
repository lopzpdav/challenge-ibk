package com.retoibk.customer.bcs.application.service;

import com.retoibk.customer.bcs.application.ports.input.CustomerInPort;
import com.retoibk.customer.bcs.application.ports.output.DatabaseOutPort;
import com.retoibk.customer.bcs.domain.exceptions.IdNotFoundException;
import com.retoibk.customer.bcs.domain.mapper.CustomerMapper;
import com.retoibk.customer.bcs.domain.response.CustomerListResponseDTO;
import com.retoibk.customer.bcs.domain.response.CustomerListResponseEncryptedDTO;
import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Base64;

import static com.retoibk.customer.bcs.domain.constants.CostumerConstants.ID_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService implements CustomerInPort {

    private final DatabaseOutPort databaseOutPort;
    private final CustomerMapper customerMapper;
    private final EncryptionService encryptionService;

    @Override
    public Flux<CustomerListResponseEncryptedDTO> getCustomerList() {
        return databaseOutPort.getCustomerList()
                .map(customer -> new CustomerListResponseEncryptedDTO(encryptionService.encrypt(customer.getId().toString())))
                .switchIfEmpty(Flux.error(new IdNotFoundException(String.format(ID_NOT_FOUND_MESSAGE, "id"))));
    }

    @Override
    public Mono<CustomerResponseDTO> getCustomerDetails(String id) {
        return databaseOutPort.getCustomer(Long.valueOf(encryptionService.decrypt(id)))
                .map(customerMapper::toDTO)
                .switchIfEmpty(Mono.error(new IdNotFoundException(String.format(ID_NOT_FOUND_MESSAGE, id))));
    }
}

package com.retoibk.customer.bcs.application.service;

import com.retoibk.customer.bcs.application.ports.input.CustomerInPort;
import com.retoibk.customer.bcs.application.ports.output.DatabaseOutPort;
import com.retoibk.customer.bcs.domain.exceptions.IdNotFoundException;
import com.retoibk.customer.bcs.domain.mapper.CustomerMapper;
import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Base64;

import static com.retoibk.customer.bcs.domain.constants.CostumerConstants.ID_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService implements CustomerInPort {

    private final DatabaseOutPort databaseOutPort;
    private final CustomerMapper customerMapper;

    @Override
    public Mono<CustomerResponseDTO> getCustomerDetails(Long id) {
        return databaseOutPort.getCustomer(id)//ADD UTIL PARA DESENCRIPTAR ID Y CAMBIAR TIPO ID A STRING
                .doOnNext(System.out::println)
                .map(customerMapper::toDTO)
                .switchIfEmpty(Mono.error(new IdNotFoundException(String.format(ID_NOT_FOUND_MESSAGE, id))));
    }

//    public Long decodeBase64(String base64Value) {
//        byte[] decodedBytes = Base64.getDecoder().decode(base64Value);
//        return Long.valueOf(new String(decodedBytes));
//    }
}

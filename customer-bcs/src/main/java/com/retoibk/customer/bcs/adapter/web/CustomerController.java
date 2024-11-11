package com.retoibk.customer.bcs.adapter.web;

import com.retoibk.customer.bcs.application.ports.input.CustomerInPort;
import com.retoibk.customer.bcs.domain.request.RequestDTO;
import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
//import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerInPort customerInPort;

    @PostMapping("/customer")
//    @Operation(summary = "Consulta informacion del cliente", description = "Endpoint para consultar informacion del cliente")
    public Mono<CustomerResponseDTO> getCustomer(@RequestBody @Valid RequestDTO request) {
        return customerInPort.getCustomerDetails(request.id());
    }
}

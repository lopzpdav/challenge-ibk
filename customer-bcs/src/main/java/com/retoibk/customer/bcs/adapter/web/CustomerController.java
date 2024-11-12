package com.retoibk.customer.bcs.adapter.web;

import com.retoibk.customer.bcs.application.ports.input.CustomerInPort;
import com.retoibk.customer.bcs.domain.request.RequestDTO;
import com.retoibk.customer.bcs.domain.response.CustomerListResponseEncryptedDTO;
import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerInPort customerInPort;

    @GetMapping("/list")
    @Operation(summary = "Consulta lista de clientes", description = "Endpoint para consultar lista de clientes")
    public Flux<CustomerListResponseEncryptedDTO> getCustomerlist() {
        return customerInPort.getCustomerList();
    }

    @PostMapping("/customer")
    @Operation(summary = "Consulta informacion del cliente", description = "Endpoint para consultar informacion del cliente")
    public Mono<CustomerResponseDTO> getCustomer(@RequestBody @Valid RequestDTO request) {
        return customerInPort.getCustomerDetails(request.id());
    }
}

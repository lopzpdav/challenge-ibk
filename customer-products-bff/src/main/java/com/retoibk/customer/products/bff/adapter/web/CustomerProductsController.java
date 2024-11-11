package com.retoibk.customer.products.bff.adapter.web;

import com.retoibk.customer.products.bff.application.ports.input.CustomerProductsInPort;
import com.retoibk.customer.products.bff.domain.request.RequestDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerProductsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
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
public class CustomerProductsController {

    private final CustomerProductsInPort customerProductsInPort;

    @PostMapping("/customer/products")
    @Operation(summary = "Consulta info cliente", description = "Endpoint para consultar informacion del cliente")
    public Mono<CustomerProductsResponseDTO> getCustomer(@RequestBody @Valid RequestDTO request) {
        return customerProductsInPort.getCustomerProducts(request.uniqueCode());
    }
}

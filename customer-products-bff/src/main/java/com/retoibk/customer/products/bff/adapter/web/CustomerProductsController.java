package com.retoibk.customer.products.bff.adapter.web;

import com.retoibk.customer.products.bff.application.ports.input.CustomerProductsInPort;
import com.retoibk.customer.products.bff.domain.request.RequestDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerListResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerProductsResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/customer-products-bff")
@RequiredArgsConstructor
public class CustomerProductsController {

    private final CustomerProductsInPort customerProductsInPort;

    @GetMapping("/customer/list")
    @Operation(summary = "Consulta lista de clientes", description = "Endpoint para consultar lista de clientes")
    public Flux<CustomerListResponseDTO> getCustomerList() {
        return customerProductsInPort.getCustomerList();
    }

    @PostMapping("/customer/products")
    @Operation(summary = "Consulta datos del cliente y productos", description = "Endpoint para consultar informacion y productos del cliente")
    public Mono<CustomerProductsResponseDTO> getCustomer(@RequestBody @Valid RequestDTO request) {
        return customerProductsInPort.getCustomerProducts(request.uniqueCode());
    }
}

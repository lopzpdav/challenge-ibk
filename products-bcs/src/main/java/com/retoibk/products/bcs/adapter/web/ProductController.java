package com.retoibk.products.bcs.adapter.web;

import com.retoibk.products.bcs.application.ports.input.ProductInPort;
import com.retoibk.products.bcs.domain.request.RequestDTO;
import com.retoibk.products.bcs.domain.response.ProductResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductInPort productInPort;

    @PostMapping("/products")
    public Flux<ProductResponseDTO> getCustomer(@RequestBody @Valid RequestDTO request) {
        return productInPort.getCustomerProducts(request.customerId());
    }
}

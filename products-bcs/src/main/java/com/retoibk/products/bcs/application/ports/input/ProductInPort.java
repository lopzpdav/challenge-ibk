package com.retoibk.products.bcs.application.ports.input;

import com.retoibk.products.bcs.domain.response.ProductResponseDTO;
import reactor.core.publisher.Flux;

public interface ProductInPort {
    Flux<ProductResponseDTO> getCustomerProducts(String id);
}

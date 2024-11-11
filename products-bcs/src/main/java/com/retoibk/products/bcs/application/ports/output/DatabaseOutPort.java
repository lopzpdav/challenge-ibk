package com.retoibk.products.bcs.application.ports.output;

import com.retoibk.products.bcs.adapter.entities.Product;
import reactor.core.publisher.Flux;

public interface DatabaseOutPort {
    Flux<Product> getProducts(Long customerId);
}

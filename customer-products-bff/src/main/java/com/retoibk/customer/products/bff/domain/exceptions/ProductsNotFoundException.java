package com.retoibk.customer.products.bff.domain.exceptions;

public class ProductsNotFoundException extends RuntimeException {
    public ProductsNotFoundException(String message) {
        super(message);
    }
}

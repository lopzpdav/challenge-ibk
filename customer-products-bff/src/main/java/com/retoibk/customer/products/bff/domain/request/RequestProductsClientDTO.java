package com.retoibk.customer.products.bff.domain.request;

import jakarta.validation.constraints.NotNull;

public record RequestProductsClientDTO(
        @NotNull (message = "id must not be null") Long customerId){
}

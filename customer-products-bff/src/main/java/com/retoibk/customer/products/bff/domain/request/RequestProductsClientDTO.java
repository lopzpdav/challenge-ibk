package com.retoibk.customer.products.bff.domain.request;

import jakarta.validation.constraints.NotBlank;

public record RequestProductsClientDTO(
        @NotBlank(message = "id must not be null") String customerId){
}

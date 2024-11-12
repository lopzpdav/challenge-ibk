package com.retoibk.products.bcs.domain.request;

import jakarta.validation.constraints.NotBlank;

public record RequestDTO(
        @NotBlank(message = "id must not be null") String customerId){
}

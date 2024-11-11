package com.retoibk.products.bcs.domain.request;

import jakarta.validation.constraints.NotNull;

public record RequestDTO(
        @NotNull (message = "id must not be null") Long customerId){
}

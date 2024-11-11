package com.retoibk.customer.bcs.domain.request;

import jakarta.validation.constraints.NotNull;

public record RequestDTO(
        @NotNull (message = "id must not be null") Long id){
}

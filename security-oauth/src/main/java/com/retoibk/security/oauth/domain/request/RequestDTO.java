package com.retoibk.security.oauth.domain.request;

import jakarta.validation.constraints.NotBlank;

public record RequestDTO(
        @NotBlank(message = "grandType must not be null") String grandType,
        @NotBlank (message = "username must not be null") String username,
        @NotBlank (message = "password must not be null") String password){
}

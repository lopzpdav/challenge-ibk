package com.retoibk.products.bcs.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponseDTO (
    Integer code,
    String error,
    List<String> message){
}

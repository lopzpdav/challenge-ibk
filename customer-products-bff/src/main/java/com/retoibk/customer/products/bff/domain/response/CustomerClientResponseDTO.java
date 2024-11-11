package com.retoibk.customer.products.bff.domain.response;

import com.retoibk.customer.products.bff.domain.enums.DocumentTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CustomerClientResponseDTO(
        String name,
        String lastName,
        @Enumerated(EnumType.STRING) DocumentTypeEnum documentType,
        String documentNumber){
}

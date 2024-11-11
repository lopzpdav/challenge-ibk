package com.retoibk.customer.bcs.domain.response;

import com.retoibk.customer.bcs.domain.enums.DocumentTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record CustomerResponseDTO(
        String name,
        String lastName,
        @Enumerated(EnumType.STRING) DocumentTypeEnum documentType,
        String documentNumber){
}

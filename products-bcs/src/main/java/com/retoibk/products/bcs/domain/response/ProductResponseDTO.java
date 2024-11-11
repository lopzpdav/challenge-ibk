package com.retoibk.products.bcs.domain.response;

import com.retoibk.products.bcs.domain.enums.ProductTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

public record ProductResponseDTO(
        @Enumerated(EnumType.STRING) ProductTypeEnum productType,
        String productName,
        BigDecimal balance) {
}

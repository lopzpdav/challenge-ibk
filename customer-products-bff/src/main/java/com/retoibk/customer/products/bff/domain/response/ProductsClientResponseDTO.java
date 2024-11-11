package com.retoibk.customer.products.bff.domain.response;

import com.retoibk.customer.products.bff.domain.enums.ProductTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

public record ProductsClientResponseDTO(
        @Enumerated(EnumType.STRING) ProductTypeEnum productType,
        String productName,
        BigDecimal balance) {
}

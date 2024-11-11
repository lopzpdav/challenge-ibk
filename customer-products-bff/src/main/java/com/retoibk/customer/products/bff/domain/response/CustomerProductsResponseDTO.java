package com.retoibk.customer.products.bff.domain.response;

import java.util.List;

public record CustomerProductsResponseDTO(
        CustomerClientResponseDTO customerData,
        List<ProductsClientResponseDTO> listProducts) {
}

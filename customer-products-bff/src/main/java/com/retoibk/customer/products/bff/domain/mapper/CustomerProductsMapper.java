package com.retoibk.customer.products.bff.domain.mapper;

import com.retoibk.customer.products.bff.domain.response.CustomerClientResponseDTO;
import com.retoibk.customer.products.bff.domain.response.CustomerProductsResponseDTO;
import com.retoibk.customer.products.bff.domain.response.ProductsClientResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.InjectionStrategy.FIELD;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, injectionStrategy = FIELD)
public interface CustomerProductsMapper {
    @Mapping(target = "customerData", source = "customerDto")
    @Mapping(target = "listProducts", source = "listProductsDto")
    CustomerProductsResponseDTO toResponseDTO(CustomerClientResponseDTO customerDto, List<ProductsClientResponseDTO> listProductsDto);
}

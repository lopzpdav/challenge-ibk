package com.retoibk.products.bcs.domain.mapper;

import com.retoibk.products.bcs.adapter.entities.Product;
import com.retoibk.products.bcs.domain.response.ProductResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.InjectionStrategy.FIELD;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = IGNORE, injectionStrategy = FIELD)
public interface ProductMapper {
    Product INSTANCE = Mappers.getMapper(Product.class);

    ProductResponseDTO toDTO (Product product);
}

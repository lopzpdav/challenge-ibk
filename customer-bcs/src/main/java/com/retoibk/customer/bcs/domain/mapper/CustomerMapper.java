package com.retoibk.customer.bcs.domain.mapper;

import com.retoibk.customer.bcs.adapter.entities.Customer;
import com.retoibk.customer.bcs.domain.response.CustomerResponseDTO;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
public interface CustomerMapper {
    CustomerResponseDTO toDTO (Customer customer);
}

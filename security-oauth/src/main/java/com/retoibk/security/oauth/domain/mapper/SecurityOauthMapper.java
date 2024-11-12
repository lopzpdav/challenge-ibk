package com.retoibk.security.oauth.domain.mapper;

import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;
import static org.mapstruct.ReportingPolicy.ERROR;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ERROR)
public interface SecurityOauthMapper {
//    CustomerResponseDTO toDTO (Customer customer);
}

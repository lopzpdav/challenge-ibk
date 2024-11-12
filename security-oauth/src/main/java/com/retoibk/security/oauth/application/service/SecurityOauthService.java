package com.retoibk.security.oauth.application.service;

import com.retoibk.security.oauth.domain.exceptions.IdNotFoundException;
import com.retoibk.security.oauth.application.ports.input.SecurityOauthInPort;
import com.retoibk.security.oauth.application.ports.output.SecurityOauthOutPort;
import com.retoibk.security.oauth.domain.mapper.SecurityOauthMapper;
import com.retoibk.security.oauth.domain.response.SecurityOauthResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.retoibk.security.oauth.domain.constants.SecurityOauthConstants.ID_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class SecurityOauthService implements SecurityOauthInPort {
//    private final SecurityOauthOutPort securityOauthOutPort;
//    private final SecurityOauthMapper securityOauthMapper;
//
//    @Override
//    public Mono<SecurityOauthResponseDTO> getCustomerDetails(Long id) {
//        return securityOauthOutPort.getCustomer(id)//ADD UTIL PARA DESENCRIPTAR ID Y CAMBIAR TIPO ID A STRING
//                .map(customerMapper::toDTO)
//                .switchIfEmpty(Mono.error(new IdNotFoundException(String.format(ID_NOT_FOUND_MESSAGE, id))));
//    }

}

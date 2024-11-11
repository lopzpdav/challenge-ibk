package com.retoibk.products.bcs.application.service;

import com.retoibk.products.bcs.application.ports.input.ProductInPort;
import com.retoibk.products.bcs.application.ports.output.DatabaseOutPort;
import com.retoibk.products.bcs.domain.exceptions.ProductNotFoundException;
import com.retoibk.products.bcs.domain.mapper.ProductMapper;
import com.retoibk.products.bcs.domain.response.ProductResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import static com.retoibk.products.bcs.domain.constants.ProductConstants.PRODUCTS_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService implements ProductInPort {

    private final DatabaseOutPort databaseOutPort;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductResponseDTO> getCustomerProducts(Long id) {
        return databaseOutPort.getProducts(id)//ADD DESENCRIPTAR BASE64
                .map(productMapper::toDTO)
                .switchIfEmpty(Flux.error(new ProductNotFoundException(String.format(PRODUCTS_NOT_FOUND_MESSAGE, id))));
    }
}

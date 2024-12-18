package com.retoibk.customer.bcs.adapter.config.handler;

import com.retoibk.customer.bcs.domain.exceptions.IdNotFoundException;
import com.retoibk.customer.bcs.domain.response.ErrorResponseDTO;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomerExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus
    public ResponseEntity<ErrorResponseDTO> idNotFoundException(IdNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDTO resultException = new ErrorResponseDTO(
                status.value(),
                status.getReasonPhrase(),
                Collections.singletonList(ex.getMessage())
        );

        return new ResponseEntity<>(resultException, status);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus
    public ResponseEntity<ErrorResponseDTO> webExchangeBindException(WebExchangeBindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<String> lisErrors = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());

        ErrorResponseDTO resultException = new ErrorResponseDTO(
                status.value(),
                status.getReasonPhrase(),
                lisErrors
        );

        return new ResponseEntity<>(resultException, status);
    }

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus
    public ResponseEntity<ErrorResponseDTO> responseStatusException(ResponseStatusException ex) {
        HttpStatus status = HttpStatus.valueOf(ex.getStatusCode().value());
        ErrorResponseDTO resultException = new ErrorResponseDTO(
                status.value(),
                ex.getReason(),
                Collections.singletonList(ex.getReason())
        );
        return new ResponseEntity<>(resultException, status);
    }
}

package com.retoibk.customer.products.bff.adapter.web;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

@RestController
public class AuthorizationController {

    @GetMapping("/authorized")
    public Mono<Map<String,String>> authorize(@RequestParam String code) {
        return Mono.just(Collections.singletonMap("authorizationCode", code));
    }
}

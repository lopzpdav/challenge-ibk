package com.retoibk.security.oauth.adapter.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/security/auth")
@RequiredArgsConstructor
public class SecurityOauthController {

    @GetMapping("/authorized")
    public Mono<Map<String, String>> authorize(@RequestParam @Valid String code) {
        return Mono.just(Collections.singletonMap("code", code));
    }

    @GetMapping("/logout")
    public Mono<Map<String, String>> logout() {
        return Mono.just(Collections.singletonMap("logout", "Ok"));
    }

    @GetMapping("/getcustomerid")
    public Mono<String> encriptCustomerId() {
//        String encripted =
//        return Mono.just();
        return null;
    }

}

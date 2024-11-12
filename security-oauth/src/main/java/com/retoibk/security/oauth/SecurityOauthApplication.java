package com.retoibk.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class SecurityOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityOauthApplication.class, args);
	}

}

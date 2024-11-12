package com.retoibk.customer.bcs.adapter.config.encryption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class EncryptionConfig {

    @Bean
    KeyStore encryptionKeyStore() throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        try (InputStream fis = getClass().getClassLoader().getResourceAsStream("keystore.jks")) {
            if (fis == null) {
                throw new FileNotFoundException("Keystore file not found in classpath");
            }
            keyStore.load(fis, "customer".toCharArray());
        }
        return keyStore;
    }
}

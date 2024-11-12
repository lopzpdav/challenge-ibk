package com.retoibk.products.bcs.application.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class EncryptionService {

    private final KeyStore rsaKeyStore;

    public String decrypt(String encryptedValue) {
        try {
            // Obtén la clave privada del keystore
            PrivateKey privateKey = (PrivateKey) rsaKeyStore.getKey("customer-products-key", "customer".toCharArray());

            // Configura el descifrado con el algoritmo RSA
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // Decodifica el valor cifrado desde Base64 y descífralo
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedValue);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Convierte el resultado a String
            String decryptedValue = new String(decryptedBytes);
            System.out.println("Decrypted Value: " + decryptedValue);

            return decryptedValue;
        } catch (Exception e) {
            return Strings.EMPTY;
        }
    }
}

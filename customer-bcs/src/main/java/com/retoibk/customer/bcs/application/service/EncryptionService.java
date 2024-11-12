package com.retoibk.customer.bcs.application.service;

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

    public String encrypt(String arg) {
        try {
            // Obtén la clave pública o privada del keystore
            PublicKey publicKey = rsaKeyStore.getCertificate("customer-products-key").getPublicKey();
            // PrivateKey privateKey = (PrivateKey) keyStore.getKey("your-key-alias", "your-key-password".toCharArray());

            // Cifrar un mensaje con la clave pública
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(arg.getBytes());

            // Imprime el valor cifrado en Base64
            String encryptedValue = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted Value: " + encryptedValue);

            return encryptedValue;
        } catch (Exception e) {
            return Strings.EMPTY;
        }
    }

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

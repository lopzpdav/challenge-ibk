package com.retoibk.security.oauth.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

@Service
public class EncryptionService {

    @Qualifier("rsaKeyStore")
    @Autowired
    private KeyStore rsaKeyStore;

    public String encrypt(String arg) throws KeyStoreException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
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
    }
}

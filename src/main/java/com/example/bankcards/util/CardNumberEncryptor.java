package com.example.bankcards.util;

import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CardNumberEncryptor {
    private final StrongTextEncryptor encryptor;

    public CardNumberEncryptor(@Value("${jasypt.encryptor.password}") String password) {
        this.encryptor = new StrongTextEncryptor();
        this.encryptor.setPassword(password);
    }

    public String encrypt(String plain) {
        return encryptor.encrypt(plain);
    }

    public String decrypt(String encrypted) {
        return encryptor.decrypt(encrypted);
    }

}

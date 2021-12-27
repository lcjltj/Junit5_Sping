package com.example.junit5_database.common.util;

import org.springframework.stereotype.Component;

@Component
public class PasswordEncryption {

    public String encode(String password) {
        return password;
    }
}

package com.example.junit5_database.test.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SignUpRequestDTO {

    private final String email;
    private final String name;
    private final String password;

}

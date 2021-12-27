package com.example.junit5_database.test.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DefaultExceptionType {
    USED_EMAIL("사용중인 이메일 입니다.", 100),
    USED_NICKNAME("사용중인 닉네임 입니다.", 101);

    private final String message;
    private final int errorCode;
}

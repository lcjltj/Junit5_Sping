package com.example.junit5_database.test.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = -8221495409365185745L;
    private final int errorCode;

    public CustomException(DefaultExceptionType defaultExceptionType) {
        super(defaultExceptionType.getMessage());
        this.errorCode = defaultExceptionType.getErrorCode();
    }
}

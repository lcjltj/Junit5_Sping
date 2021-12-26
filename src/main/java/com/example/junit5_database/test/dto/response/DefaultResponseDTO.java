package com.example.junit5_database.test.dto.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DefaultResponseDTO<T> {

    private final T body;

    private final long errorCode;

    private final String errorMessage;

    public DefaultResponseDTO() {
        body = null;
        errorCode = 0;
        errorMessage = "";
    }

    public DefaultResponseDTO(T body) {
        this.body = body;
        errorCode = 0;
        errorMessage = "";
    }

    public DefaultResponseDTO(long errorCode, String errorMessage) {
        body = null;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}

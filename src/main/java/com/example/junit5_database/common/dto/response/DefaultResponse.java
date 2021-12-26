package com.example.junit5_database.common.dto.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DefaultResponse<T> {

    private final T body;
    private final long errorCode;
    private final String errorMessage;

    public DefaultResponse() {
        body = null;
        errorCode = 0;
        errorMessage = "";
    }

    public DefaultResponse(T body) { // 성공
        this.body = body;
        errorCode = 0;
        errorMessage = "";
    }

    public DefaultResponse(long errorCode, String errorMessage) { // 실패
        this.body = null;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}

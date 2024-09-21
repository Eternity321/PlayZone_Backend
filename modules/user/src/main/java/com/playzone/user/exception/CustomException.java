package com.playzone.user.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class CustomException extends RuntimeException {

    private final String code;
    @Getter private final HttpStatus status;

    public CustomException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public ApiErrorResponse toApiErrorResponse() {
        return new ApiErrorResponse(code, this.getMessage());
    }
}

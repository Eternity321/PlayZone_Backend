package com.playzone.user.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException {
    public NotFoundException(String message) {
        super(message, "404", HttpStatus.NOT_FOUND);
    }
}

package com.playzone.user.exception;

import org.springframework.http.HttpStatus;

public class KeycloakException extends CustomException {
    public KeycloakException(String message) {
        super(message, "400", HttpStatus.BAD_REQUEST);
    }
}

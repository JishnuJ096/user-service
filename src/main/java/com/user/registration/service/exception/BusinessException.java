package com.user.registration.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException{

    public static final String BAD_REQUEST = String.valueOf(HttpStatus.BAD_REQUEST.value());
    public BusinessException(String userDoesNotExists) {
        super(userDoesNotExists);
    }
}

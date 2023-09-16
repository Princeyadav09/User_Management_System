package com.cafe.management.system.Exception;

import com.cafe.management.system.model.response.ExceptionResponse;
import com.cafe.management.system.utils.CafeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<Object> HandleBadCredentialsException() {
        return CafeUtils.getResponseEntity(new ExceptionResponse<>(400 , "Invalid Username or Password !!"), HttpStatus.BAD_REQUEST);
    }
}

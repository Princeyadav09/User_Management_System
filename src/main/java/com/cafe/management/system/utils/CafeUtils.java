package com.cafe.management.system.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CafeUtils {

    private CafeUtils() {

    }

    public static ResponseEntity<Object> getResponseEntity(Object responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<Object>(responseMessage, httpStatus);
    }

}

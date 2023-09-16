package com.cafe.management.system.model.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class LoginResponse<T> {

    private String message;
    private String Token;
    private Integer statusCode;

    public LoginResponse(String message,String token, Integer statusCode) {
        this.message = message;
        this.Token = token;
        this.statusCode = statusCode;
    }
}

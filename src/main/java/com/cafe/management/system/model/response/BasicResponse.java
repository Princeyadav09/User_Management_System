package com.cafe.management.system.model.response;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BasicResponse<T> {

    private T data;
    private String message;
    private Integer statusCode;

    public BasicResponse(T userDto, String message, Integer statusCode) {
        this.data = userDto;
        this.message = message;
        this.statusCode = statusCode;
    }
}

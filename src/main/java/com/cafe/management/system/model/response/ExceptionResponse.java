package com.cafe.management.system.model.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExceptionResponse<T> {

    private Integer errorCode;
    private String errorDesc;

    public ExceptionResponse(Integer errorCode,String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
}

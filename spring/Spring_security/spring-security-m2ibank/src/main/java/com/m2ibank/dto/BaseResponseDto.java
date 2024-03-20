package com.m2ibank.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BaseResponseDto {

    private Object message;
    private Object data;

    public BaseResponseDto(Object message){
        this.message = message;
    }

}

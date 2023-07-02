package com.example.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    // general
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "SERVER ERROR"),
    // login module
    LOGIN_ERROR(500210, "Invalid mobile or password"),
    MOBILE_ERROR(500211, "Invalid mobile format"),
    BIND_ERROR(500212, "Parameter validation error"),
    MOBILE_NOT_EXIST(500213, "mobile number not exist"),
    PASSWORD_UPDATE_FAIL(500214, "fail to update the password"),
    // seckill module
    EMPTY_STOCK(500500, "Insufficient stock"),
    REPEAT_ERROR(500501, "The purchase limit is 1"),
    ;
    private final Integer code;
    private final String message;
}

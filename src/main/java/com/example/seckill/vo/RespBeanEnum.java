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
    SESSION_ERROR(500215, "user does not exist"),
    // seckill module
    EMPTY_STOCK(500500, "Insufficient stock"),
    REPEAT_ERROR(500501, "The purchase limit is 1"),
    REQUEST_ILLEGAL(500502, "Illegal request, please retry"),
    ERROR_CAPTCHA(500503, "Wrong captcha, please re-enter"),
    ACCESS_LIMIT_REACHED(500504, "Accessed too frequently, please retry later"),
    // order module
    ORDER_NOT_EXIST(500300, "order info not exist"),
    ;
    private final Integer code;
    private final String message;
}

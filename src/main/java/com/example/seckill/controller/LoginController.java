package com.example.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // restcontroller will add response body to all methods by default, so it will return an object instead of redirect
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
}

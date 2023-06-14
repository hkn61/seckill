package com.example.seckill.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 测试
@org.springframework.stereotype.Controller
@RequestMapping("/demo")
public class Controller {

    // 测试页面跳转
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name", "xxxx");
        return "hello";
    }
}

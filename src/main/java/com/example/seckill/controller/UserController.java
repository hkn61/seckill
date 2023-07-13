package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.rabbitmq.MQSender;
import com.example.seckill.vo.RespBean;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 *
 * @author hkn
 * @date 2023-06-13
 */
@RestController
@RequestMapping("/user")
@Api(value = "",tags = "")
public class UserController {

    @Autowired MQSender mqSender;

    // user info (test)
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }


    // test sending message to RabbitMQ
    @RequestMapping("/mq")
    @ResponseBody
    public void mq(){
        mqSender.send("hello mq");
    }
}

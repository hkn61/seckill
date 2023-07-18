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


//    // test sending message to RabbitMQ
//    @RequestMapping("/mq")
//    @ResponseBody
//    public void mq(){
//        mqSender.send("hello mq");
//    }
//
//
//    // RabbitMQ fanout mode
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public void mq01(){
//        mqSender.send("hello mq fanout");
//    }
//
//
//    // RabbitMQ direct mode 1
//    @RequestMapping("/mq/direct01")
//    @ResponseBody
//    public void mq02(){
//        mqSender.send01("hello mq direct red");
//    }
//
//
//    // RabbitMQ direct mode 2
//    @RequestMapping("/mq/direct02")
//    @ResponseBody
//    public void mq03(){
//        mqSender.send02("hello mq direct green ");
//    }
//
//
//    // RabbitMQ topic mode 1
//    @RequestMapping("/mq/topic01")
//    @ResponseBody
//    public void mq04(){
//        mqSender.send03("hello mq topic queue 01 ");
//    }
//
//
//    // RabbitMQ topic mode 2
//    @RequestMapping("/mq/topic02")
//    @ResponseBody
//    public void mq05(){
//        mqSender.send04("hello mq topic queue 02 ");
//    }
//
//
//    // RabbitMQ topic mode 2
//    @RequestMapping("/mq/header01")
//    @ResponseBody
//    public void mq06(){
//        mqSender.send05("hello mq header 01 ");
//    }
//
//
//    // RabbitMQ topic mode 2
//    @RequestMapping("/mq/header02")
//    @ResponseBody
//    public void mq07(){
//        mqSender.send06("hello mq header 02 ");
//    }
}

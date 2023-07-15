package com.example.seckill.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Slf4j
public class MQReceiver {

    @RabbitListener(queues = "queue")
    public void receive(Object msg){
        log.info("receive message: " + msg);
    }

    @RabbitListener(queues = "queue_fanout01")
    public void receive01(Object msg){
        log.info("receive message from queue_fanout01: " + msg);
    }

    @RabbitListener(queues = "queue_fanout02")
    public void receive02(Object msg){
        log.info("receive message from queue_fanout02: " + msg);
    }

    @RabbitListener(queues = "queue_direct01")
    public void receive03(Object msg){
        log.info("receive message from queue_direct01: " + msg);
    }

    @RabbitListener(queues = "queue_direct02")
    public void receive04(Object msg){
        log.info("receive message from queue_direct02: " + msg);
    }

    @RabbitListener(queues = "queue_topic01")
    public void receive05(Object msg){
        log.info("receive message from queue_topic01: " + msg);
    }

    @RabbitListener(queues = "queue_topic02")
    public void receive06(Object msg){
        log.info("receive message from queue_topic02: " + msg);
    }

    @RabbitListener(queues = "queue_header01")
    public void receive07(Message msg){
        log.info("receive message object from queue_header01: " + msg);
        log.info("receive message from queue_header01: " + new String(msg.getBody()));
    }

    @RabbitListener(queues = "queue_header02")
    public void receive08(Message msg){
        log.info("receive message object from queue_header02: " + msg);
        log.info("receive message from queue_header02: " + new String(msg.getBody()));
    }
}

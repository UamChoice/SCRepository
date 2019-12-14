package com.example.service.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSend {

    @Autowired
    RabbitTemplate rabbitTemplate;


    public void testSend() {
        //参数介绍： 交换机名字，路由建， 消息内容
        rabbitTemplate.convertAndSend("directExchange", "direct.key", "hello");
    }
}

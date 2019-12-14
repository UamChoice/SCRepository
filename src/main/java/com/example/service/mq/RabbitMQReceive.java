package com.example.service.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Component
public class RabbitMQReceive {

    @RabbitListener(queues = "testQueue")
    public void get(String message) throws Exception{
        System.out.println(message);
    }
}

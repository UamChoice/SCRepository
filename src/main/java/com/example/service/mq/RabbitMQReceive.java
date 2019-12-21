package com.example.service.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Component
public class RabbitMQReceive {

    /**
     * 接收字符串，发送过来的消息就是String类型的
     * @param message
     * @throws Exception
     */
    @RabbitListener(queues = "testQueue")
    public void get(String message) throws Exception{
        System.out.println(message);
    }

    /**
     * 接收Message对象，如果设置了RabbitTemplate#setMessageConverter，接收的都是Message对象
     * @param message
     * @param string
     * @throws Exception
     */
    @RabbitListener(queues = "testQueue")
    public void get(Message message, String string) throws Exception{
        System.out.println(new String(message.getBody(),"UTF-8"));
        System.out.println("接收Message");
    }
}

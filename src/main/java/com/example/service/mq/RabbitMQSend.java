package com.example.service.mq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class RabbitMQSend {

    @Autowired
    RabbitTemplate rabbitTemplate;

//    @PostConstruct
//    public void init(){
//        初始化时设置 确认回调方法  或者  失败回调方法
//        rabbitTemplate.setConfirmCallback();
//    }

    /**
     * 发送Message
     */
    public void  sendMessage(){
        CorrelationData correlationData = new CorrelationData("订单ID");
        //direct.key
        Map<String,Object> map = new HashMap<>();
        map.put("name","123");
        map.put("password","123456");
        rabbitTemplate.convertAndSend("directExchange", "direct.key", map,correlationData);

        //也可以使用如下方法(故意发错，使用的错误routingKey)
        rabbitTemplate.convertAndSend("directExchange", "direct.keyerror", JSONObject.toJSONString(map),correlationData);

    }

    /**
     * 发送字符串
     */
    public void testSend() {
        //参数介绍： 交换机名字，路由建， 消息内容
        rabbitTemplate.convertAndSend("directExchange", "direct.key", "hello");

        //发送消息的时候附带一个CorrelationData参数,这个对象可以设置一个id，可以是你的业务id 方便进行对应的操作
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("directExchange","direct.key","hello",correlationData);
    }
}

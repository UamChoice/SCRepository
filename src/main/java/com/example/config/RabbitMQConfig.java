package com.example.config;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost",5672);
        //在构造方法传入了
        // connectionFactory.setHost();
        // connectionFactory.setPort();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("testhost");
        //是否开启消息确认机制
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    /**
     * 创建交换机
     * @return
     */
    @Bean
    public DirectExchange defaultExchange() {
        //返回一个direct类型的交换机，发送消息时指定 routingKey，发给交换机，进而发送给对应队列
        return new DirectExchange("directExchange");
    }
    @Bean
    public Queue queue() {
        //名字 是否持久化
        return new Queue("testQueue", true);
    }
    @Bean
    public Binding binding() {
        //绑定一个队列 to: 绑定到哪个交换机上面 with：绑定的路由建（routingKey）
        return BindingBuilder.bind(queue()).to(defaultExchange()).with("direct.key");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        //注意 这个ConnectionFactory 是使用javaconfig方式配置连接的时候才需要传入的 如果是yml配置的连接的话是不需要的
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //发送确认
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                // 是否发送成功
                System.out.println(ack);
                // 不成功的原因
                System.out.println(cause);
                // 发送消息带过来的数据
                System.out.println(correlationData);
            }
        });

        //开启失败回调
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                // message : 发送的消息 "hello"+ 发送消息的配置
                System.out.println(message);
                // 失败码
                System.out.println(replyCode);
                // 失败错误内容
                System.out.println(replyText);
                // 交换机
                System.out.println(exchange);
                // 路由键
                System.out.println(routingKey);
            }
        });
        // 发送消息时转换对象
        rabbitTemplate.setMessageConverter(new MessageConverter() {
            /** 发送时 */
            @Override
            public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
                //设置了文本模式，会把消息转换成文本string，否则会返回getBytes
                messageProperties.setContentType("text/xml");
                messageProperties.setContentEncoding("UTF-8");
                Message message = new Message(JSON.toJSONBytes(o),messageProperties);
                System.out.println("调用了消息解析器");
                return message;
            }
            /** 接收时 */
            @Override
            public Object fromMessage(Message message) throws MessageConversionException {
                return null;
            }
        });
        return rabbitTemplate;
    }

    /**
     * 备用交换机，directExchange[1]的备用交换机bakExchange[2]
     * 如果发送到交换机1的消息没有发送成功，则会发到交换机2，如果还不成功，会调用失败方法setReturnCallback
     * @return
     */
    @Bean
    public DirectExchange bakExchange() {
        Map<String, Object> map = new HashMap<>();
        map.put("alternate-exchange","bakExchange");
        return  new DirectExchange("directExchange",false,false,map);
    }
}

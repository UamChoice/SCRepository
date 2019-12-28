package com.db.service;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaSend {

    public void sendMsg() throws Exception{
        Properties properties = new Properties();
        //指定kafka服务器地址 如果是集群可以指定多个 但是就算只指定一个他也会去集群环境下寻找其他的节点地址
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092 ");
        //key序列化器
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        //value序列化器
        properties.setProperty("value.serializer",StringSerializer.class.getName());

        //可以实现自己的分区逻辑
        //properties.setProperty("partitioner.class",MyPartitioner.class.getSimpleName());

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(properties);
        //主题, 分区（） ,key（null时轮询分区，否则根据hash值确定分区）,消息内容
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("test-topic",1,"testKey","hello");

        //发送消息并获取消息，以下方式是同步（阻塞）方式
        //Future<RecordMetadata> send = kafkaProducer.send(record);
        //RecordMetadata recordMetadata = send.get();
        //System.out.println(recordMetadata);

        Future<RecordMetadata> send = kafkaProducer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                //异步方式，发送消息完成后执行
                if( null != recordMetadata){
                    System.out.println(recordMetadata.topic());
                }
            }
        });

        //发送的数据

        kafkaProducer.flush();
        kafkaProducer.close();
    }
}

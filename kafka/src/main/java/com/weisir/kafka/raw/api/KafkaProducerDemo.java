package com.weisir.kafka.raw.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p></p>
 *
 * @author: 研发部-魏巍
 * @since: 2019/9/15 18:09
 * @version: v2.6.3
 */
public class KafkaProducerDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 初始化配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","47.107.123.189:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // 创建 kafaka Producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);

        // 创建 Kakfa 消息  = ProducerRecord
        String topic = "gupao";
        Integer partition = 0;
        Long timestamp = System.currentTimeMillis();
        String key = "message-key";
        String value = "9.18shijian";
        ProducerRecord<String,String> producerRecord = new ProducerRecord(topic,partition,timestamp,key,value);

        // 发送消息
        Future<RecordMetadata> future = kafkaProducer.send(producerRecord);
//        //强制执行
        future.get();

    }
}

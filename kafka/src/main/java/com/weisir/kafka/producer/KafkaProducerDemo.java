package com.weisir.kafka.producer;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * <p>生产消息</p>
 *
 * @author: 研发部-魏巍
 * @since: 2019/9/17 11:07
 * @version: v2.6.3
 */
@Component
public class KafkaProducerDemo {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String send(String topic, String key, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);
        future.addCallback(result -> logger.debug("发送成功：{}", result), ex -> logger.debug("发送失败：{}", ex));
        return "success";
    }

}

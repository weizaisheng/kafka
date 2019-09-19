package com.weisir.kafka.consume;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * <p>消费消息</p>
 *
 * @author: 研发部-魏巍
 * @since: 2019/9/17 11:18
 * @version: v2.6.3
 */
@Component
public class KafkaConsumeDemo {

    private Logger logger = LoggerFactory.getLogger("KafkaConsumeDemo");

    @KafkaListener(topics = {"gupao"})
    public void receive(ConsumerRecord<?, ?> record) {
        logger.info("key: {}, value: {}, record: {}", record.key(), record.value(), record);
    }
}

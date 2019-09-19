package com.weisir.kafka.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * <p></p>
 *
 * @author: 研发部-魏巍
 * @since: 2019/9/15 23:00
 * @version: v2.6.3
 */
@RestController
public class SpringKafKapProducerController {

    private final KafkaTemplate<String,String> kafkaTemplate;

    private final String topic;

    @Autowired
    public SpringKafKapProducerController(KafkaTemplate<String,String> template, @Value("${kafka.topic}") String topic){
        this.kafkaTemplate = template;
        this.topic = topic;
    }

    @PostMapping("/messag/send")
    public Boolean send(@RequestParam String message){
        try {
            kafkaTemplate.send(topic,message).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return true;
    }

}

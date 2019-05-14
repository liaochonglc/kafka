package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;
    @Scheduled(cron = "00/1 * * * * ?")
    public void send(){
        ListenableFuture lc = kafkaTemplate.send("test", "你好" + UUID.randomUUID());
        lc.addCallback(l->
            System.out.println("成功"), throwable -> System.out.println("消息发送失败")
        );
    }
}

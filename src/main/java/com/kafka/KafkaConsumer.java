package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

public class KafkaConsumer {
    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.println("kafka的key: " + record.key());
        System.out.println("kafka的value: " + record.value().toString());
    }
}

package io.rosan.springBootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private Logger loggger = LoggerFactory.getLogger(KafkaProducer.class);

    //configure kafka template
    private KafkaTemplate<String, String> kafkaTemplate;

    //constructor based dependency injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        loggger.info("Message sent"+message);
        kafkaTemplate.send("greeting-topic",message);
    }
}

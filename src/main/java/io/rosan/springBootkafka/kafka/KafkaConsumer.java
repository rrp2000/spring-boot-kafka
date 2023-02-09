package io.rosan.springBootkafka.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "greeting-topic", groupId = "myGroup")
    public void consume(String message) {
        logger.info("Received message: " + message);
    }
}

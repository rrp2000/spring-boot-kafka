package io.rosan.springBootkafka.kafka;


import io.rosan.springBootkafka.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, UserModel> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, UserModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserModel data){

        logger.info("message sent ->"+ data.toString());
        Message<UserModel> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"greeting-topic")
                .build();

        kafkaTemplate.send(message);
    }
}

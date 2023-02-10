package io.rosan.springBootkafka.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    private static Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, UserModel> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, UserModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserModel data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userAsString = mapper.writeValueAsString(data);
        logger.info("Sending message: " + data.toString());
        Message<String> message = MessageBuilder
                .withPayload(userAsString)
                .setHeader(KafkaHeaders.TOPIC, "greeting-topic-json")
                .build();

        kafkaTemplate.send(message);
    }
}

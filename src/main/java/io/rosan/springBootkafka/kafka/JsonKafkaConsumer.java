package io.rosan.springBootkafka.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.rosan.springBootkafka.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class JsonKafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    ObjectMapper mapper = new ObjectMapper();
    @KafkaListener(topics = "greeting-topic-json", groupId = "myGroup")

    public void consume(String message) throws JsonProcessingException {
        try{
            UserModel user = mapper.readValue(message,UserModel.class);
            logger.info("Received message: " + user);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

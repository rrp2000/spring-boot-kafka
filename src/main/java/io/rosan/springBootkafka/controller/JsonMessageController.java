package io.rosan.springBootkafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.rosan.springBootkafka.kafka.JsonKafkaProducer;
import io.rosan.springBootkafka.kafka.KafkaProducer;
import io.rosan.springBootkafka.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody UserModel user) throws JsonProcessingException {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent to kafka topic");
    }
}

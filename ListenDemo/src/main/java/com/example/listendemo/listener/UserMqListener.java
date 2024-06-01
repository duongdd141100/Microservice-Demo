package com.example.listendemo.listener;

import com.example.listendemo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Component
@RabbitListener(queues = "USER_QUEUE")
public class UserMqListener {
    @Autowired
    private ObjectMapper objectMapper;

    @RabbitHandler
    public void receive(String message) throws InterruptedException, JsonProcessingException {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("Users Queue: " + objectMapper.readValue(message, List.class));
        watch.stop();
    }
}

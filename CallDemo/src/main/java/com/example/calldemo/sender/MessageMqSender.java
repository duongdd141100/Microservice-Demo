package com.example.calldemo.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMqSender extends RabbitMqSender<String>{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange directExchange;

    @Override
    public void send(String s) throws JsonProcessingException {
        rabbitTemplate.convertAndSend("MESSAGE_QUEUE", s);
    }
}

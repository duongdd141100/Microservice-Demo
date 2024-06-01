package com.example.calldemo.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public abstract class RabbitMqSender<T> {
    public abstract void send(T t) throws JsonProcessingException;
}

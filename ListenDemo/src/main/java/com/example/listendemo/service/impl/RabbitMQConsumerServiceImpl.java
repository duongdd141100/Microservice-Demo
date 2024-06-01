package com.example.listendemo.service.impl;

import com.example.listendemo.service.RabbitMQConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumerServiceImpl implements RabbitMQConsumerService {
    @Override
    public void getMessage(String message) {
        log.info(message);
    }
}

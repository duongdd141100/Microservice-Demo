package com.example.listendemo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "MESSAGE_QUEUE")
@Component
public class MessageMqListener {

    @RabbitHandler
    public void receive(String message) {
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("Message Queue: " + message);
        watch.stop();
    }
}

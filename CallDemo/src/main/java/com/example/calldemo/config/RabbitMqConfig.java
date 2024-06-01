package com.example.calldemo.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public DirectExchange direct() {
        return new DirectExchange("tut.direct");
    }
    @Bean
    public Queue messageQueue() {
        return new AnonymousQueue();
    }
    @Bean
    public Binding bindingMessageQueue(DirectExchange directExchange, Queue messageQueue) {
        return BindingBuilder.bind(messageQueue)
                .to(directExchange)
                .with("MESSAGE_QUEUE");
    }
    @Bean
    public Queue userQueue() {
        return new AnonymousQueue();
    }
    @Bean
    public Binding bindingUserQueue(DirectExchange directExchange, Queue userQueue) {
        return BindingBuilder.bind(userQueue)
                .to(directExchange)
                .with("USER_QUEUE");
    }
}

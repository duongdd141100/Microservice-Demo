package com.example.calldemo.sender;

import com.example.calldemo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserMqSender extends RabbitMqSender<UserDto>{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DirectExchange directExchange;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void send(UserDto userDto) throws JsonProcessingException {
        List<UserDto> users;
        if (redisTemplate.opsForValue().get("users") == null) {
            users = Arrays.asList(userDto);
            redisTemplate.opsForValue().set("users", objectMapper.writeValueAsString(users));
        } else {
            users = objectMapper.readValue(redisTemplate.opsForValue().get("users"), List.class);
            users.add(userDto);
            redisTemplate.opsForValue().set("users", objectMapper.writeValueAsString(users));
        }
        rabbitTemplate.convertAndSend("USER_QUEUE", objectMapper.writeValueAsString(users));
    }
}

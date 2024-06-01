package com.example.calldemo.service.impl;

import com.example.calldemo.dto.UserDto;
import com.example.calldemo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<UserDto> findOne() throws JsonProcessingException {
        UserDto user = objectMapper.readValue(redisTemplate.opsForValue().get("user"), UserDto.class);
        return Arrays.asList(user);
    }

    @Override
    public List<UserDto> findAll() throws JsonProcessingException {
        List<UserDto> users = objectMapper.readValue(redisTemplate.opsForValue().get("users"), List.class);
        return users;
    }
}

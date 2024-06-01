package com.example.calldemo.service;

import com.example.calldemo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface UserService {
    List<UserDto> findOne() throws JsonProcessingException;
    List<UserDto> findAll() throws JsonProcessingException;
}

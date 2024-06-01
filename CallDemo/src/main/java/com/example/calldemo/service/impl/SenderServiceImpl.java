package com.example.calldemo.service.impl;

import com.example.calldemo.dto.UserDto;
import com.example.calldemo.sender.MessageMqSender;
import com.example.calldemo.sender.UserMqSender;
import com.example.calldemo.service.SenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderServiceImpl implements SenderService {
    @Autowired
    private MessageMqSender messageMqSender;

    @Autowired
    private UserMqSender userMqSender;
    @Override
    public void send(String type) throws JsonProcessingException {
        if (type.equals("USER")) {
            UserDto userDto = new UserDto();
            userDto.setUsername("duongdd");
            userDto.setPassword("1414");
            userMqSender.send(userDto);
        } else {
            messageMqSender.send("Message Queue");
        }
    }
}

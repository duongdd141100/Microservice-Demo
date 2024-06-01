package com.example.calldemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SenderService {
    void send(String type) throws JsonProcessingException;
}

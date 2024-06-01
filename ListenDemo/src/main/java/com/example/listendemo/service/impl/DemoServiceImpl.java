package com.example.listendemo.service.impl;

import com.example.listendemo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String demo(String name) {
        return "Do Duc " + name;
    }
}

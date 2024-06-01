package com.example.calldemo.service.impl;

import com.example.calldemo.rest_service.DemoRestServiceSender;
import com.example.calldemo.service.DemoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoRestServiceImpl implements DemoRestService {
    @Autowired
    private DemoRestServiceSender demoRestService;

    @Override
    public String demo() {
        return demoRestService.demoRest();
    }
}

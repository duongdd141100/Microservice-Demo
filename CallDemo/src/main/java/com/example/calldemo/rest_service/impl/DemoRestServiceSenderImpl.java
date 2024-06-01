package com.example.calldemo.rest_service.impl;

import com.example.calldemo.rest_service.DemoRestServiceSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class DemoRestServiceSenderImpl implements DemoRestServiceSender {
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private RetryTemplate retryTemplate;
    @Override
    public String demoRest() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Duong");
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8089/listen")
                .queryParam("name", "Duong")
                .encode().toUriString();
        return retryTemplate.execute((context) -> {
            log.info("CALL!");
            String response = restTemplate.getForEntity(url, String.class).getBody();
            log.info(response);
            return response;
        });
    }
}

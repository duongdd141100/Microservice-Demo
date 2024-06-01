package com.example.calldemo.controller;

import com.example.calldemo.service.DemoRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {
    @Autowired
    private DemoRestService demoRestService;

    @GetMapping("/send")
    public ResponseEntity<String> demo() {
        try {
            return ResponseEntity.ok(demoRestService.demo());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

package com.example.listendemo.controller;

import com.example.listendemo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/listen")
@Slf4j
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("")
    public ResponseEntity<String> demo(@RequestParam String name) {
        try {
            Random random = new Random();
            Integer num = random.nextInt(4);
            log.info("Num = " + num);
            if (num.equals(3)) {
                return ResponseEntity.ok(String.valueOf(num));
            } else {
                throw new RuntimeException("ERROR LISTEN");
            }
//            return ResponseEntity.ok(demoService.demo(name));
        } catch (Exception e) {
            log.error("ERROR");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

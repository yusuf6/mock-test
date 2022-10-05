package com.saifee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MockController {

    @GetMapping
    public String hello() {
        return "Hello, Yusuf!";
    }
}

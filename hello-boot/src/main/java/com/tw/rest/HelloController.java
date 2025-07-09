package com.tw.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class HelloController {

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hello Spring Boot!";
    }
}

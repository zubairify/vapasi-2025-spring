package com.tw.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/content")
public class ContentController {

    @GetMapping(value = "/text", produces = "text/plain")
    public String textGreeting() {
        return "Text: Welcome to Spring Boot!";
    }

    @GetMapping(value = "/html", produces = "text/html")
    public String htmlGreeting() {
        return "<h1>HTML: Welcome to Spring Boot!</h1>";
    }

    @GetMapping(value = "/xml", produces = "text/xml")
    public String xmlGreeting() {
        return "<?xml version=\"1.0\"?><greeting>XML: Welcome to Spring Boot</greeting>";
    }

    @GetMapping(value = "/json", produces = "application/json")
    public String jsonGreeting() {
        return "{\"greeting\":\"Hello World!\"}";
    }
}




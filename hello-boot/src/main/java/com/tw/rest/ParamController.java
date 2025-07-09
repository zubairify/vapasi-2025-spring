package com.tw.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/params")
public class ParamController {

    // http://localhost:8080/params/hello/Zubair
    @GetMapping(value = "/hello/{pname}")
    public String sayHello(@PathVariable("pname") String name) {
        return "Hello " + name;
    }

    // http://localhost:8080/params/bye?pname=Zubair
    @GetMapping(value = "/bye")
    public String sayBye(@RequestParam("pname") String name) {
        return "Goodbye " + name;
    }
}

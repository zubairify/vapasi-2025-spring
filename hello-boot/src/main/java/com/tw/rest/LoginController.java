package com.tw.rest;

import com.tw.bean.Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    // http://localhost:8080/login/auth?username=zubair&password=secret
    @GetMapping(value = "/auth", produces = "text/html")
    public String authenticate(@RequestParam String username, @RequestParam String password) {
        if(username.equals("zubair") && password.equals("secret"))
            return "<h1>Login Success</h1>";
        else
            return "<h1>Login Failure</h1>";
    }

    // http://localhost:8080/login/auth2
    @GetMapping(value = "/auth2",consumes = "application/json", produces = "text/html")
    public String authenticate2(@RequestBody Login login) {
        if(login.getUsername().equals("zubair") && login.getPassword().equals("secret"))
            return "<h1>Login Success</h1>";
        else
            return "<h1>Login Failure</h1>";
    }
}



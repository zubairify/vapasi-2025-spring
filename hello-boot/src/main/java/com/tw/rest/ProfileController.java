package com.tw.rest;

import com.tw.bean.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping(value = "/get", produces = "application/json")
    public Profile getProfile(@RequestParam String fullName, @RequestParam int age, @RequestParam double salary) {
        Profile profile = new Profile();
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setSalary(salary);
        return profile;
    }

    @PostMapping(value = "/add", consumes = "application/json")
    public String addProfile(@RequestBody Profile profile) {
        return "Profile added successfully for " + profile.getFullName();
    }
}

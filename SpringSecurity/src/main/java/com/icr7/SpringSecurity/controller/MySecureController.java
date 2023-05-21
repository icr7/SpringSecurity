package com.icr7.SpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class MySecureController {

    @GetMapping("/user")
    public String getUser(){
        return"Welcome User !!!";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Welcome Admin !!!";
    }

    @GetMapping("/other")
    public String getOther(){
        return "Hi There !!!";
    }
}

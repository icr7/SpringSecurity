package com.icr7.SpringSecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class MySecureController {

    @GetMapping("/user")
    public String getUser(){
        return"Welcome User: " +getLoginUserName()+"!!!";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "Welcome Admin: "+getLoginUserName()+" !!!";
    }

    @GetMapping("/other")
    public String getOther(){
        return "Hi There !!!";
    }

    public String getLoginUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }
}

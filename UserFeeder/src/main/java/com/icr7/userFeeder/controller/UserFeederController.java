package com.icr7.userFeeder.controller;

import com.icr7.userFeeder.service.UserFeederService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class UserFeederController {

    @Autowired
    UserFeederService userFeederService;
    @GetMapping("/feedUser/{n}")
    public String insertFeedUser(@PathVariable int n){
        System.out.println("------------> n: "+n);
        userFeederService.insertUsers(n);
        return n*2+" Users are Feeded";
    }
}

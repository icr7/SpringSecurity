package com.icr7.SpringSecurity.controller;

import com.icr7.SpringSecurity.Repository.UserRepository;
import com.icr7.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sign-up")
public class SignUpController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add-account")
    public void addAccount(@RequestBody UserTable newUser){
        System.out.println("********** "+newUser.getUserName() +" added *********");
        userRepository.save(newUser);
    }

}

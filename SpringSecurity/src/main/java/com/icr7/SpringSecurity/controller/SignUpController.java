package com.icr7.SpringSecurity.controller;

import com.icr7.SpringSecurity.Model.UserTable;
import com.icr7.SpringSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add-account")
    public void addAccount(@RequestBody UserTable newUser){
        userRepository.save(newUser);
    }

}

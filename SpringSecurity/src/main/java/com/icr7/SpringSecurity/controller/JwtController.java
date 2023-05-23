package com.icr7.SpringSecurity.controller;

import com.icr7.SpringSecurity.Model.MyUserDetail;
import com.icr7.SpringSecurity.Service.MyUserDetailsService;
import com.icr7.SpringSecurity.util.JwtUtil;
import com.icr7.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping("/jwt")
public class JwtController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/generate")
    public String generateJwt(@RequestBody UserTable user) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Wrong Credentials "+e);
        }

        UserDetails userDetail = userDetailsService.loadUserByUsername(user.getUserName());
        return jwtUtil.generateToken(userDetail);
    }

    @GetMapping("/validate")
    public String validateToken(HttpServletRequest httpServletRequest){
        String token=httpServletRequest.getHeader("authorization").substring(7);
        String username=jwtUtil.extractUsername(token);
        UserDetails userDetail = userDetailsService.loadUserByUsername(username);
        return "Is "+username+" valid user : "+jwtUtil.validateToken(token,userDetail);
    }
    

}

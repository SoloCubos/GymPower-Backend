package com.gympower.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gympower.web.DTO.LoginRequest;
import com.gympower.web.DTO.LoginResponse;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(path = "/login")
public class LoginController {
    
    @GetMapping("/index")
    public String index(){
        return "Pene Enorme";
    }

    @GetMapping("/index2")
    public String index2(){
        return "Pene Enano";
    }


}

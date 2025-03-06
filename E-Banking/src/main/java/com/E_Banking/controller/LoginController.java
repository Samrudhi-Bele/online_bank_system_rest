package com.E_Banking.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.E_Banking.model.Users;
import com.E_Banking.service.LoginService;

@RestController
@CrossOrigin("http://localhost:4200")
//@RequestMapping("/api")
public class LoginController {
    
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        return loginService.loginUser(username, password);
    }
}


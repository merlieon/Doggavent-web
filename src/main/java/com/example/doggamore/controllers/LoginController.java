package com.example.doggamore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    // Login mapping
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

}

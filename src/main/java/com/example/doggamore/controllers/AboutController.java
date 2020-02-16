package com.example.doggamore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    // to show about window
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

}

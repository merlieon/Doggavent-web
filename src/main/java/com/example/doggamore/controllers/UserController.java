package com.example.doggamore.controllers;

import com.example.doggamore.models.User;
import com.example.doggamore.services.UserService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getUser() throws IOException, JSONException {
        userService.getAllUsers();
        return "userid = ";
    }

    @PostMapping
    public String createUser(){
        return "creat euser;";
    }


}

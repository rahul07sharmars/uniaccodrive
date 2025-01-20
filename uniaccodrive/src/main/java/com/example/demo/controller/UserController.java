package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }
    
    @GetMapping
    public ResponseEntity<List<User>> getUser(){
    	return ResponseEntity.ok(userService.getUser());
    }
    
}


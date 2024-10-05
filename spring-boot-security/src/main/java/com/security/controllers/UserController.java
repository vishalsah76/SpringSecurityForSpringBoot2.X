package com.security.controllers;

import com.security.models.User;
import com.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }
    //get user by username

    @GetMapping("/{userName}")
    public User getUser(@PathVariable String userName){
        return userService.getUser(userName);

    }

    //add user
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

}

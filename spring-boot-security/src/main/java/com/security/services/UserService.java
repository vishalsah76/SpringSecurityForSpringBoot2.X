package com.security.services;

import com.security.models.User;
import com.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(){

    }

    //get All User
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    //get user by username
    public User getUser(String userName){
        return userRepo.findByUserName(userName);

    }

    //add user
    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
         return userRepo.save(user);
    }
}

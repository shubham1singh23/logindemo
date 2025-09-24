package com.spring1.demo11.controller;

import com.spring1.demo11.model.User;
import com.spring1.demo11.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/register")
    public String register(@RequestBody User obj){
        userRepo.save(obj);
        return "Success";
    }
    @PostMapping("/login")
    public String login(@RequestBody User obj){
        User u=userRepo.findByUsername(obj.getUsername());
        if(u!=null&&obj.getPassword().equals(u.getPassword())){
            return "Success";
        }
        return "Login failed";
    }
}

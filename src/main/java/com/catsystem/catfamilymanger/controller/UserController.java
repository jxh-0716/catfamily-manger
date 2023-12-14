package com.catsystem.catfamilymanger.controller;

import org.springframework.web.bind.annotation.RestController;

import com.catsystem.catfamilymanger.pojo.User;
import com.catsystem.catfamilymanger.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(String name, String password, String gender, String email, String phonenumber,
            String nickname) {
        User u = userService.findByUsername(name);
        if (u == null) {
            userService.register(name, password, gender, email, phonenumber, nickname);
            return "success";
        } else {
            return "fail";
        }
    }

    @PostMapping("/login")
    public String login(String name, String password) {
        User u = userService.findByUsername(name);
        if (u == null) {
            return "fail";
        } else {
            if (u.getPassword().equals(password)) {
                return "success";
            } else {
                return "fail";
            }
        }
    }

    @GetMapping("/info")
    public User getinfo(String name) {
        User u = userService.findByUsername(name);
        return u;
    }

}

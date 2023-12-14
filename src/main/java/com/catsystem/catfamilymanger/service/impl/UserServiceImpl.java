package com.catsystem.catfamilymanger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catsystem.catfamilymanger.mapper.UserMapper;
import com.catsystem.catfamilymanger.pojo.User;
import com.catsystem.catfamilymanger.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String name) {
        User u = userMapper.findByUsername(name);
        return u;
    }

    @Override
    public Void register(String name, String password, String gender, String email, String phonenumber,
            String nickname) {
        userMapper.register(name, password, gender, email, phonenumber, nickname);
        return null;
    }
}

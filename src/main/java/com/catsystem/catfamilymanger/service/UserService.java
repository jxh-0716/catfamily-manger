package com.catsystem.catfamilymanger.service;

import com.catsystem.catfamilymanger.pojo.User;

public interface UserService {
    User findByUsername(String name);

    Void register(String name, String password, String gender, String email, String phonenumber, String nickname);
}

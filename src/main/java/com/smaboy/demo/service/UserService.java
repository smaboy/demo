package com.smaboy.demo.service;

import com.smaboy.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserInfo();
    void addUserInfo();
    List<User> queryByUsername(String username);
}

package com.smaboy.demo.service;

import com.smaboy.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserInfo();
    int addUserInfo(String username, String password, String phonef);
    List<User> queryByUsername(String username);
}

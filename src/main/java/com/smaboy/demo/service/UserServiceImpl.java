package com.smaboy.demo.service;

import com.smaboy.demo.entity.User;
import com.smaboy.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserInfo() {
        User user = new User();
        user.setUsername("小明");
        user.setPassword(12341234);
        return user;
    }

    @Override
    public void addUserInfo() {
        String username = "jack";
        int password = 123;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userMapper.addUserInfo(user);
    }
}



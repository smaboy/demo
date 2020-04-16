package com.smaboy.demo.service;

import com.smaboy.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User getUserInfo() {
        User user = new User();
        user.setName("小明");
        user.setPassword(12341234);
        return user;
    }
}



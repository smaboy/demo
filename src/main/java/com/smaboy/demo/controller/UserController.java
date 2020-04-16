package com.smaboy.demo.controller;

import com.smaboy.demo.entity.Response;
import com.smaboy.demo.entity.User;
import com.smaboy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @RequestMapping(value = "/getUserItem",method = RequestMethod.GET)
    public String getUserItem(){
        User user = service.getUserInfo();
        return user.toString();
    }

    @RequestMapping(value = "/addUserInfo",method = RequestMethod.GET)
    public Response addUserInfo(){
        service.addUserInfo();
        Response res = new Response();
        res.setMsg("添加成功");
        res.setCode(1);
        return res;
    }
}

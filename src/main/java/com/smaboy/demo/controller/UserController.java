package com.smaboy.demo.controller;

import com.smaboy.demo.entity.Response;
import com.smaboy.demo.entity.User;
import com.smaboy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
    public Response addUserInfo(@RequestBody Map<String,String> person){
//        service.addUserInfo();
        Response res = new Response();
        res.setMsg("添加成功");
        res.setCode(1);
        return res;
    }

    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public Response register(@RequestBody Map<String,String> person){
        Response response = new Response();
        String name = person.get("username");
        String password = person.get("password");
        String phone = person.get("phone");
        //添加筛选逻辑，姓名、密码、手机号有一项为空则不处理
        if (name !=null && !name.isEmpty() && password != null && !password.isEmpty() && phone != null && !phone.isEmpty()){
            List<User> userList = service.queryByUsername(name);
            //2.判断是否有重复用户名
            if(userList!=null && userList.size()>0){
                response.setCode(202);
                response.setMsg("注册失败，用户名重复,请更换");
                return response;
            }else {
                int count = service.addUserInfo(name,password,phone);
                if(count>0){
                    //3.没有重复用户名，注册成功
                    response.setCode(0);
                    response.setMsg("注册成功");
                    return response;
                }else {
                    response.setCode(203);
                    response.setMsg("用户重复，注册失败");
                    return response;
                }
            }
        }else {
            response.setCode(201);
            response.setMsg("注册失败，请检查用户名、密码、手机号是否为空");
        }

        return response;
    }
}

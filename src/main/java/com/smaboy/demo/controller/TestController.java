package com.smaboy.demo.controller;

import com.smaboy.demo.entity.User;
import com.smaboy.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;
    @Test
    public void test() throws SQLException {
        System.out.println("获取的数据库连接为:"+dataSource.getConnection());
//        User user = new User();
//        user.setUsername("小明");
//        user.setPassword(123);
//        userMapper.addUserInfo(user);
        List<User> userList = userMapper.queryByUsername("张三");
        System.out.println(userList.toString());
    }
}

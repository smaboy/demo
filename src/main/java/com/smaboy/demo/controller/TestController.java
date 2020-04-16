package com.smaboy.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.activation.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
    @Autowired
    DataSource dataSource;
    @Test
    public void test(){
        System.out.println("获取的数据库连接为:"+dataSource.getName());
    }
}

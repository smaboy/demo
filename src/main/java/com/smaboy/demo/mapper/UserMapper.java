package com.smaboy.demo.mapper;

import com.smaboy.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    int addUserInfo(User user);

    List<User> queryByUsername(String username);

}

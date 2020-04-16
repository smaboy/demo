package com.smaboy.demo.mapper;

import com.smaboy.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int addUserInfo(User user);
}

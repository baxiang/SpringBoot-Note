package com.github.springboot.dao;

import com.github.springboot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("SELECT id,name,age,balance FROM user LIMIT 10")
    List<User> selectAllUser();

    @Insert("INSERT INTO user(name,age,balance) VALUES(#{name},#{age},#{balance})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);

    User selectUserByName(String name);

}

package com.github.springboot.service;

import com.github.springboot.bean.User;
import com.github.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
   private UserDao userDao;

    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    public int insertUser(User user) {
       return userDao.insertUser(user);
    }

    public User selectUserByName(String name) {
        return userDao.selectUserByName(name);
    }
}

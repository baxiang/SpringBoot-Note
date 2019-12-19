package com.github.springboot.controller;

import com.github.springboot.bean.User;
import com.github.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User>users(){
        return userService.selectAllUser();
    }

    @PostMapping("add")
    public User addUser(@RequestBody User user){
         user.setId(userService.insertUser(user));
         return user;
    }

    @GetMapping ("/search")
    public User selectUserByName(@RequestParam("name") String name){
        return userService.selectUserByName(name);
    }
}

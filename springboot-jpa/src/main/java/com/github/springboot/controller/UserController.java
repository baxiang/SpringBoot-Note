package com.github.springboot.controller;

import com.github.springboot.domain.Result;
import com.github.springboot.domain.User;
import com.github.springboot.repository.UserRepository;
import com.github.springboot.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping()
    public Result<User> userAdd(@RequestBody User user){
        return MessageUtil.success(userRepository.save(user));
    }

    @GetMapping("list")
    public Result<User> userList() {
        return MessageUtil.success(userRepository.findAll());
    }

    @GetMapping("{id}")
    public Optional<User> userFindOne(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping()
    public List<User> findUserListByName(@RequestParam(name="name",required = true) String name) {
        return userRepository.findByName(name);
    }

    @PutMapping(value = "{id}")
    public User userUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name,
            @RequestParam("age") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }
}

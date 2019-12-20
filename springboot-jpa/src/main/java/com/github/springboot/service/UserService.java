package com.github.springboot.service;

import com.github.springboot.domain.User;
import com.github.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Integer id){
        return userRepository.getOne(id);
    }
}

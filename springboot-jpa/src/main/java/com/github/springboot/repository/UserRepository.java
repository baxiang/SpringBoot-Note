package com.github.springboot.repository;

import com.github.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User>findByName(String name);
}

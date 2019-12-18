package com.github.controller;

import com.github.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public ResponseEntity<List<User>> addUser(@RequestBody User user) {
        users.add(user);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            if (next.getId()==id){
                iterator.remove();
            }
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/users")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user")
    public ResponseEntity getUsersByName(@RequestParam("name") String name) {
        List<User> collect = users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }
}

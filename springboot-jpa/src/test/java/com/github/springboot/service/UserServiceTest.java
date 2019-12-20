package com.github.springboot.service;

import com.github.springboot.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
   public void findByIdTest(){
        User user = userService.findById(1);
        Assert.assertNotEquals(null,user);
        Assert.assertEquals("ming",user.getName());
        Assert.assertEquals("20",user.getAge());
    }
}

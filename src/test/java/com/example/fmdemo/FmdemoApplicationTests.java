package com.example.fmdemo;

import com.example.fmdemo.entity.User;
import com.example.fmdemo.service.UserService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FmdemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("jame");
        user.setAge(18);
        user.setAddress("光明路");
        user.setCity("上海");
        User res = userService.save(user);
        System.err.println("插入结果:" + res);
    }

    @Test
    void list(){
        userService.findAll().stream().forEach(System.err :: println);
    }
}

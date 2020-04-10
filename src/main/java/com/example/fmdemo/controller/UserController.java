package com.example.fmdemo.controller;

import com.example.fmdemo.entity.User;
import com.example.fmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Created by dz on 2020-4-1
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User find(@PathVariable(value = "id") Long id){
        return userService.findById(id).get();
    }

    @PostMapping("/")
    public boolean update(@RequestBody User user) {
        System.err.println("update params:"+user);
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public boolean delete(@PathVariable("id") Long id){
        System.out.println(id);
        return userService.deleteById(id);
    }

    @PutMapping("/")
    public String save(@RequestBody User user){
        User res = userService.save(user);
        return String.valueOf(user.getId());
    }
}

package com.example.fmdemo.controller;

import com.example.fmdemo.entity.User;
import com.example.fmdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * Created by dz on 2020-4-1
 * @author Administrator
 */
@Api(produces = "user")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @ApiOperation(value = "获取用户信息", notes = "list",response = List.class)
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "根据ID查询用户", notes = "find",response = User.class)
    public User find(@PathVariable(value = "id") Long id){
        return userService.findById(id).get();
    }

    @PostMapping("/")
    @ApiOperation(value = "更新用户", notes = "update",response = boolean.class)
    public boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @ApiOperation(value = "删除用户", notes = "delete",response = boolean.class)
    public boolean delete(@PathVariable("id") Long id){
        return userService.deleteById(id);
    }

    @PutMapping("/")
    @ApiOperation(value = "添加用户", notes = "add",response = String.class)
    public String save(@RequestBody User user){
        User res = userService.save(user);
        return String.valueOf(res.getId());
    }
}

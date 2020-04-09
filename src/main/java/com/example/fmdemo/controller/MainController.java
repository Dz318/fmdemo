package com.example.fmdemo.controller;

import com.example.fmdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/***
 * Created by dz on 2020-4-2
 * @author Administrator
 */
@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String main(Model model){
        model.addAttribute("param", "jack");
        model.addAttribute("users",userService.findAll());
        return "index";
    }
}

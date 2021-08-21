package com.xgy.bookmall.controller;

import com.xgy.bookmall.entity.User;
import com.xgy.bookmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(ModelMap map) {
        return "index";
    }

    @PostMapping("/bcd")
    @ResponseBody
    public User dd(@RequestParam("name") String name, @RequestParam("id") String id) {
        return new User(1, name, "abc", "1587656");
    }

}
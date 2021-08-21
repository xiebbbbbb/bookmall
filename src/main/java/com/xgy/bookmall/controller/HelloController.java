package com.xgy.bookmall.controller;

import com.xgy.bookmall.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(ModelMap map) {
        return "index";
    }

    // get post方法记得加ResponseBody
    @RequestMapping("/a")
    @ResponseBody
    public User duser() {
        return new User();
    }

}
package com.xgy.bookmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("login2")
    public String login() {
        return "login";
    }

    @GetMapping("regist2")
    public String regist() {
        return "regist";
    }
}

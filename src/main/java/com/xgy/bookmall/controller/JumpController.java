package com.xgy.bookmall.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/jump")    // 所有方法都拥有的前缀
public class JumpController {

    @RequestMapping("/login")
    public String login() {
        System.out.println("11");
        return "login";
    }

    @RequestMapping("regist")
    public String regist() {

        return "regist";
    }
}

package com.xgy.bookmall.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("/login2")
    public String login() {
        System.out.println("11");
        return "forward:login";
    }

    @GetMapping("/regist2")
    public String regist() {

        return "forward:regist";
    }
}

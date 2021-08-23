package com.xgy.bookmall.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/jump")    // 所有方法都拥有的前缀
public class JumpController {

    @RequestMapping("/bookDetail")
    public String bookDetail() {
        return "bookDetail";
    }

    @RequestMapping("/searchResult")
    public String searchResult() {
        return "searchResult";
    }

    @RequestMapping("/cofirmOrder")
    public String cofirmOrder() {
        return "cofirmOrder";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("regist")
    public String regist() {
        return "regist";
    }

    @RequestMapping("shoppingCart")
    public String shoppingCart() {
        return "shoppingCart";
    }

    @RequestMapping("myOrder")
    public String myOrder() {
        return "myOrder";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}

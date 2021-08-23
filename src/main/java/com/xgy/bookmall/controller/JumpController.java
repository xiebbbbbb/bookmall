package com.xgy.bookmall.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class JumpController {

    @RequestMapping("/bookDetail")
    public String bookDetail() {
        return "bookDetail";
    }

    @RequestMapping("/searchResult")
    public String searchResult() {
        return "searchResult";
    }

    @RequestMapping("/confirmOrder")
    public String confirmOrder() {
        return "confirmOrder";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/regist")
    public String regist() {
        return "regist";
    }

    @RequestMapping("/shoppingCart")
    public String shoppingCart() {
        return "shoppingCart";
    }

    @RequestMapping("/myOrder")
    public String myOrder() {
        return "myOrder";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/showDetail")
    public String showDetail(){
        return "bookDetail";
    }
}




package com.xgy.bookmall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    public boolean drag = true;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/bookDetail")
    public String bookDetail() {
        return "bookDetail";
    }

    //往redis中设置库存
    @RequestMapping("/secKill")
    public String secKill() {
        if(drag) {
            //从Redis里查找剩余库存
            stringRedisTemplate.opsForValue().set("stock", 1 + "");
            drag = false;
        }
        return "secKill";
    }

    @RequestMapping("/searchResult")
    public String searchResult() {
        return "searchResult";
    }

    @RequestMapping("/confirmOrder")
    public String confirmOrder() {
        return "confirmOrder";
    }

    @RequestMapping("/confirmSeckillOrder")
    public String confirmSeckillOrder() {
        return "confirmSeckillOrder";
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




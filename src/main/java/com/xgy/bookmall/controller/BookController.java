package com.xgy.bookmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xgy.bookmall.entity.Book;
import com.xgy.bookmall.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/findAll")
    @ResponseBody
    public JSONObject findAll(@RequestParam("p") int p){
        JSONObject res = new JSONObject();
        int total = bookService.getTotNum();
        res.put("total", total);
        List<Book> booksList = bookService.findAll(p);
        String jStr = JSON.toJSONString(booksList);
        System.out.println(jStr);
        res.put("booksList", jStr);

        return res;
    }
}

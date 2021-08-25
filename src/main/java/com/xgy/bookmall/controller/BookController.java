package com.xgy.bookmall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xgy.bookmall.entity.Book;
import com.xgy.bookmall.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/book")
@CrossOrigin
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/findAll")
    @ResponseBody
    public JSONObject findAll(@RequestParam("p") int p){
        //System.out.println("p: " + p);
        JSONObject res = new JSONObject();
        int total = bookService.getTotNum();
        res.put("total", total);
        List<Book> booksList = bookService.findAll(p);
        String jStr = JSON.toJSONString(booksList);
        //System.out.println("jStr: " + jStr);
        res.put("booksList", jStr);

        return res;
    }

    @GetMapping("/showDetail")
    @ResponseBody
    public JSONObject showDetail(@RequestParam("bId") int bId){
        JSONObject res = new JSONObject();
        Book book = bookService.showDetail(bId);
        String jStr = JSONArray.toJSON(book).toString();
        res.put("bookInfo", jStr);

        return res;
    }

    @GetMapping("/searchByKey")
    @ResponseBody
    public JSONObject searchByKey(@RequestParam("p") int p, @RequestParam("key") String key){
        JSONObject res = new JSONObject();
        List<Book> booksList = bookService.searchByKey(p, "%" + key + "%");
        String jStr = JSON.toJSONString(booksList);
        res.put("booksList", jStr);
        int total = bookService.getTotNumByKey("%" + key + "%");
        res.put("total", total);

        return res;
    }

    @GetMapping("/searchByTags")
    @ResponseBody
    public JSONObject searchByTags(@RequestParam("p") int p, @RequestParam("tags") String tags){
        JSONObject res = new JSONObject();
        List<String> tagsInfo = JSON.parseArray(tags, String.class);
        List<Book> booksList = bookService.searchByTags(p, tagsInfo);
        String jStr = JSON.toJSONString(booksList);
        res.put("booksList", jStr);
        int total = bookService.getTotNumByTags(tagsInfo);
        res.put("total", total);

        return res;
    }

    @GetMapping("/searchByTagsAndKey")
    @ResponseBody
    public JSONObject searchByTagsAndKey(@Param("p") int p, @Param("tags") String tags, @Param("key") String key){
        JSONObject res = new JSONObject();
        List<String> tagsInfo = JSON.parseArray(tags, String.class);
        List<Book> booksList = bookService.searchByTagsAndKey(p, tagsInfo, "%"+ key +"%");
        String jStr = JSON.toJSONString(booksList);
        res.put("booksList", jStr);
        int total = bookService.getTotNumByTagsAndKey(tagsInfo, key);
        res.put("total", total);

        return res;
    }

}

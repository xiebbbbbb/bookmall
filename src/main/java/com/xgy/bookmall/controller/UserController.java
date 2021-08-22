package com.xgy.bookmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xgy.bookmall.entity.User;
import com.xgy.bookmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")    // 所有方法都拥有的前缀
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/")
//    public String index(ModelMap map) {
//        return "index";
//    }

    @PostMapping("/userRegister")
    @ResponseBody
    public JSONObject userRegister(@RequestParam("uName") String uName,
                                   @RequestParam("uPwd") String uPwd,
                                   @RequestParam("uPhone") String uPhone) {
        JSONObject ret = new JSONObject();
        if (isEmpty(uName)) {
            ret.put("code", 401);
            ret.put("msg", "uName required");
            return ret;
        }
        if (isEmpty(uPwd)) {
            ret.put("code", 402);
            ret.put("msg", "uPwd required");
            return ret;
        }
        if (isEmpty(uPhone)) {
            ret.put("code", 403);
            ret.put("msg", "uPhone required");
            return ret;
        }
        // TODO: do sql
        //uid没用到
        userService.insert(new User(0, uName, uPwd, uPhone));
        ret.put("code", 200);
        ret.put("msg", "reg success");
        return ret;
    }

    @PostMapping("/userLogin")
    @ResponseBody
    public JSONObject userLogin(@RequestParam("uName") String uName,
                                @RequestParam("uPwd") String uPwd,
                                HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        if (isEmpty(uName)) {
            ret.put("code", 401);
            ret.put("msg", "uName required");
            return ret;
        }
        if (isEmpty(uPwd)) {
            ret.put("code", 402);
            ret.put("msg", "uPwd required");
            return ret;
        }
        List<User> users = userService.selectByNameAndPwd(uName, uPwd);
        if (users.size() == 0) {
            ret.put("code", 301);
            ret.put("msg", "login err");
        } else {
            httpSession.setAttribute("uId", users.get(0).getUId());
            ret.put("code", 300);
            ret.put("msg", "login success");
        }
        return ret;

    }

    @PostMapping("/isLogin")
    @ResponseBody
    public JSONObject isLogin(HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uId = httpSession.getAttribute("uId");
        if (uId == null) {
            ret.put("code", 0);
            ret.put("msg", "未登录");
        } else {
            ret.put("code", 1);
            ret.put("msg", "已登录");
        }
        return ret;
    }

    @PostMapping("userLogout")
    @ResponseBody
    public JSONObject userLogout(HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        if (httpSession.getAttribute("uId") != null) {
            httpSession.removeAttribute("uId");
            ret.put("code", 900);
            ret.put("msg", "logout success");
        } else {
            ret.put("code", 901);
            ret.put("msg", "logout err");
        }
        return ret;
    }

    protected boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

}
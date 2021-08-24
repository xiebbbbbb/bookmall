package com.xgy.bookmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xgy.bookmall.entity.Cart;
import com.xgy.bookmall.mapper.CartMapper;
import com.xgy.bookmall.service.BookService;
import com.xgy.bookmall.service.CartService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    BookService bookService;

    @GetMapping("/addBook")
    @ResponseBody
    public JSONObject addBook(@RequestParam("bId") int bId , HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        List<Cart> carts = cartService.selectByUIdAndBId(uId, bId);
        if (carts.size() == 1) {
            cartService.updateNumByUIdAndBId(uId, bId, carts.get(0).getBNum() + 1);
            ret.put("code", 101);
            ret.put("msg", "successfully update");
        } else {
            cartService.insert(new Cart(uId, bId, 1, 1));
            ret.put("code", 100);
            ret.put("msg", "successfully insert");
        }
        return ret;
    }

    @GetMapping("/deleteBook")
    @ResponseBody
    public JSONObject deleteBook(@RequestParam("bId") int bId , HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        List<Cart> carts = cartService.selectByUIdAndBId(uId, bId);
        if (carts.get(0).getBNum() == 1) {
            cartService.deleteByUIdAndBId(uId, bId);
            ret.put("code", 101);
            ret.put("msg", "successfully delete");
        } else {
            cartService.updateNumByUIdAndBId(uId, bId, carts.get(0).getBNum() - 1);
            ret.put("code", 102);
            ret.put("msg", "successfully minus");
        }
        return ret;
    }

    @GetMapping("/changeBookStatus")
    @ResponseBody
    public JSONObject changeBookStatus(@RequestParam("bId") int bId, @RequestParam("status") int status, HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        cartService.changeStatusByUIdAndBId(uId, bId, status);
        ret.put("code", 203);
        ret.put("msg", "successfully change status");
        return ret;
    }

    @GetMapping("/modifyBookNum")
    @ResponseBody
    public JSONObject modifyBookNum(@RequestParam("bId") int bId, @RequestParam("bNum") int bNum, HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        cartService.updateNumByUIdAndBId(uId, bId, bNum);
        ret.put("code", 101);
        ret.put("msg", "successfully modify");
        return ret;
    }

    @GetMapping("/getUserCart")
    @ResponseBody
    public JSONObject getUserCart(HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        // 联表查询
        return ret;
    }

    @GetMapping("/calcTotalPrice")
    @ResponseBody
    public JSONObject calcTotalPrice(HttpSession httpSession) {
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        // 联表计算
        return ret;
    }
}












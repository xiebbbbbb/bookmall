package com.xgy.bookmall.controller;

import com.alibaba.fastjson.JSONObject;
import com.xgy.bookmall.entity.Order;
import com.xgy.bookmall.entity.OrderBook;
import com.xgy.bookmall.service.OrderBookService;
import com.xgy.bookmall.service.OrderService;
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
@RequestMapping("/order")    // 所有方法都拥有的前缀
public class OrderController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private Redisson redisson;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderBookService orderBookService;

    //秒杀
    @GetMapping("/secKill")
    @ResponseBody
    public JSONObject secKill(@RequestParam("bId") int bId , HttpSession httpSession) throws InterruptedException{
        JSONObject ret = new JSONObject();
        String lockKey = bId + "";
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        RLock redissonLock = redisson.getLock(lockKey);
        try{
            redissonLock.lock(9, TimeUnit.SECONDS);
            //从Redis里查找剩余库存
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if(stock > 0){
                int realStock = stock - 1;
                //存回Redis里
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("抢到了，剩余库存：" + realStock);
                //code666 为抢到
                ret.put("code" , 666);
            }else {
                System.out.println("没有抢到，库存不足");
                //code700 为抢不到
                ret.put("code" , 700);
            }
        }finally {
            redissonLock.unlock();
        }

        System.out.println("secKill" + ret);
        return ret;
    }

    //postman测试成功
    @GetMapping("/findAll")
    @ResponseBody
    public JSONObject findAllOrder(HttpSession httpSession){
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        System.out.println(uId);
        List<Order> orders = orderService.findAll(uId);
        ret.put("list" , orders);
        ret.put("code", 400);
        System.out.println("order" + ret);
        return ret;
    }


    //postman测试成功
    @GetMapping("/deleteOrder")
    @ResponseBody
    public JSONObject deleteOrder(@RequestParam("oId") int oId){
        System.out.println(oId);
        JSONObject ret = new JSONObject();
        int res2 = orderBookService.delete(oId);
        int res = orderService.delete(oId);
        if(res == 0 || res2 == 0){
            ret.put("code", 405);
            ret.put("msg" , "删除失败");
        }
        else {
            ret.put("code", 500);
            ret.put("msg" , "删除成功");
        }
        return ret;
    }

    //postman测试成功
    @GetMapping("/receiveOrder")
    @ResponseBody
    public JSONObject receiveOrder(@RequestParam("oId") int oId){
        JSONObject ret = new JSONObject();
        int res = orderService.receive(oId);
        if(res == 0){
            ret.put("code", 405);
            ret.put("msg" , "订单不存在");
        }
        else {
            ret.put("code", 600);
            ret.put("msg" , "确认收货成功");
        }
        return ret;
    }

    //postman测试成功
    @PostMapping("/createOrder")
    @ResponseBody
    public JSONObject createOrder(@RequestParam("oTotalPrice") float oTotalPrice,
                                  @RequestParam("oAddress") String oAddress,
                                  @RequestParam("bIdList") String bIdList,
                                  @RequestParam("bNumList") String bNumList,
                                  HttpSession httpSession){
        JSONObject ret = new JSONObject();
        Object uIdObj = httpSession.getAttribute("uId");
        String uIdStr = uIdObj.toString();
        int uId = Integer.parseInt(uIdStr);
        System.out.println("uId:" + uId);
        int res2 = 0;
        int res1 = orderService.insert(new Order(0 , uId , oTotalPrice , oAddress , "进行中"));
        int oId = orderService.getoId();
        //拿到了oId
        System.out.println("能不能拿到oId啊:");
        System.out.println("oId:" + oId);
        List<String> bIdList2 = Arrays.asList(bIdList.split(","));
        List<String> bNumList2 = Arrays.asList(bNumList.split(","));
        for(int i = 0;i < bIdList2.size();i++)
        {
            res2 = orderBookService.insert(new OrderBook(oId , Integer.parseInt(bIdList2.get(i)) , Integer.parseInt(bNumList2.get(i)) ) );
        }
        if(res1 == 0 && res2 == 0){
            ret.put("code", 405);
            ret.put("msg" , "订单不存在");
        }
        else {
            ret.put("code", 600);
            ret.put("msg" , "创建订单成功");
        }
        return ret;
    }

    //返回图书信息，缺少乐爷的图书模块
    @GetMapping("/findOne")
    @ResponseBody
    public JSONObject findOne(@RequestParam("oId") int oId){
        JSONObject ret = new JSONObject();
        List<OrderBook> orderBookList = orderBookService.find(oId);
        //根据bId获取图书信息

        return ret;
    }

}

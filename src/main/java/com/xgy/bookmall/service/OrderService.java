package com.xgy.bookmall.service;

import com.xgy.bookmall.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {


    //创建订单
    int insert(@Param("order") Order order);

    //查询所有订单
    List<Order> findAll(@Param("uId") int uId);

    //删除订单
    int delete(@Param("oId") int oId);

    //查询某个订单
    List<Order> find(@Param("oId") int oId);

    //确认收货
    int receive(@Param("oId") int oId);

    //拿到oId
    int getoId();
}

package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.Order;
import com.xgy.bookmall.mapper.OrderMapper;
import com.xgy.bookmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;


    @Override
    public int insert(Order order) {
        int res = orderMapper.insert(order);
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public List<Order> findAll(int uId) {
        return orderMapper.findAll(uId);
    }

    @Override
    public int delete(int oId) {
        System.out.println("oId = " + oId);
        return orderMapper.delete(oId);
    }

    @Override
    public List<Order> find(int oId) {
        return orderMapper.find(oId);
    }

    @Override
    public int receive(int oId) {
        return orderMapper.receive(oId);
    }

    @Override
    public int getoId() {
        int res = orderMapper.getoId();
        System.out.println("res = " + res);
        return res;
    }


}

package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.OrderBook;
import com.xgy.bookmall.mapper.OrderMapper;
import com.xgy.bookmall.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderBookService")
public class OrderBookServiceImpl implements OrderBookService {

    @Autowired
    OrderBookService orderBookService;

    @Override
    public int insert(OrderBook orderBook) {
        int res = orderBookService.insert(orderBook);
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int delete(int oId) {
        return orderBookService.delete(oId);
    }

    @Override
    public List<OrderBook> find(int oId) {
        return orderBookService.find(oId);
    }
}

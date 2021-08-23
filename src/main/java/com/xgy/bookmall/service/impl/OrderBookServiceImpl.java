package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.BookDetail;
import com.xgy.bookmall.entity.OrderBook;
import com.xgy.bookmall.mapper.OrderBookMapper;
import com.xgy.bookmall.mapper.OrderMapper;
import com.xgy.bookmall.service.OrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderBookService")
public class OrderBookServiceImpl implements OrderBookService {

    @Autowired
    OrderBookMapper orderBookMapper;

    @Override
    public int insert(OrderBook orderBook) {
        int res = orderBookMapper.insert(orderBook);
        System.out.println("res = " + res);
        return res;
    }

    @Override
    public int delete(int oId) {
        System.out.println("oId = " + oId);
        return orderBookMapper.delete(oId);
    }

    @Override
    public List<BookDetail> find(int oId) {
        return orderBookMapper.find(oId);
    }
}

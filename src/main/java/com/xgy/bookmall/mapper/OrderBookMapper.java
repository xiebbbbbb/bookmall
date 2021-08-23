package com.xgy.bookmall.mapper;

import com.xgy.bookmall.entity.BookDetail;
import com.xgy.bookmall.entity.Order;
import com.xgy.bookmall.entity.OrderBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderBookMapper {

    //创建订单
    int insert(@Param("orderBook") OrderBook orderBook);

    //删除订单
    int delete(@Param("oId") int oId);

    //查询所有订单
    List<BookDetail> find(@Param("oId") int oId);


}

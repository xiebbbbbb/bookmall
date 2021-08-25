package com.xgy.bookmall.mapper;

import com.xgy.bookmall.entity.Cart;
import com.xgy.bookmall.entity.Book;
import com.xgy.bookmall.entity.CartBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    // 查询图书
    List<Cart> selectByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId);

    // 插入图书
    void insert(@Param("cart") Cart cart);

    // 增减图书
    void updateNumByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId, @Param("bNum") int bNum);

    // 删除图书
    void deleteByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId);

    // 修改图书状态
    void changeStatusByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId, @Param(("status")) int status);

    // 联表查询
    List<CartBook> selectBetweenCartAndBooks(@Param("uId") int uId);

    // 联表计算合计金额
    double countSum(@Param("uId") int uId);

}

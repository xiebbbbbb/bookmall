package com.xgy.bookmall.mapper;

import com.xgy.bookmall.entity.Cart;
import com.xgy.bookmall.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    // 查询图书
    List<Cart> selectByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId);

    // 插入图书
    int insert(@Param("Cart") Cart cart);

    // 增减图书
    int updateNumByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId, @Param("bNum") int bNum);

    // 删除图书
    int deleteByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId);

    // 修改图书状态
    int changeStatusByUIdAndBId(@Param("uId") int uId, @Param("bId") int bId, @Param(("status")) int status);

    // 联表查询
    List<Cart> selectBetween(@Param("Cart") Cart cart, @Param("Book") Book book);

    // 联表计算合计金额
    int countSum(@Param("Cart") Cart cart, @Param("Book") Book book, @Param("uId") int uId);

}

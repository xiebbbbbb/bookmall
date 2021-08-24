package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.Book;
import com.xgy.bookmall.entity.Cart;
import com.xgy.bookmall.mapper.CartMapper;
import com.xgy.bookmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CartService")
public class CartServiceImpl implements CartService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public List<Cart> selectByUIdAndBId(int uId, int bId) {
        return cartMapper.selectByUIdAndBId(uId, bId);
    }

    @Override
    public int insert(Cart cart) {
        return cartMapper.insert(cart);
    }

    @Override
    public int updateNumByUIdAndBId(int uId, int bId, int bNum) {
        return cartMapper.updateNumByUIdAndBId(uId, bId, bNum);
    }

    @Override
    public int deleteByUIdAndBId(int uId, int bId) {
        return cartMapper.deleteByUIdAndBId(uId, bId);
    }

    @Override
    public int changeStatusByUIdAndBId(int uId, int bId, int status) {
        return cartMapper.changeStatusByUIdAndBId(uId, bId, status);
    }

    @Override
    public List<Cart> selectBetweenTable(Cart cart, Book book) {
        return cartMapper.selectBetween(cart, book);
    }


    @Override
    public int countSum(Cart cart, Book book, int uId) {
        return cartMapper.countSum(cart, book, uId);
    }
}

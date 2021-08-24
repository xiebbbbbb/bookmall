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
    public void insert(Cart cart) {
        cartMapper.insert(cart);
    }

    @Override
    public void updateNumByUIdAndBId(int uId, int bId, int bNum) {
        cartMapper.updateNumByUIdAndBId(uId, bId, bNum);
    }

    @Override
    public void deleteByUIdAndBId(int uId, int bId) {
        cartMapper.deleteByUIdAndBId(uId, bId);
    }

    @Override
    public void changeStatusByUIdAndBId(int uId, int bId, int status) {
        cartMapper.changeStatusByUIdAndBId(uId, bId, status);
    }

    @Override
    public List<Book> selectBetweenCartAndBooks(int uId) {
        return cartMapper.selectBetweenCartAndBooks(uId);
    }

    @Override
    public double countSum(int uId) {
        return cartMapper.countSum(uId);
    }
}

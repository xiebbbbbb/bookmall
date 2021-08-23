package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.Book;
import com.xgy.bookmall.entity.Cart;
import com.xgy.bookmall.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public List<Cart> selectByUIdAndBId(int uId, int bId) {
        return null;
    }

    @Override
    public int insert(Cart cart) {
        return 0;
    }

    @Override
    public int updateNumByUIdAndBId(int uId, int bId, int bNum) {
        return 0;
    }

    @Override
    public int deleteByUIdAndBId(int uId, int bId) {
        return 0;
    }

    @Override
    public int changeStatusByUIdAndBId(int uId, int bId, int status) {
        return 0;
    }

    @Override
    public List<Cart> selectBetween(Cart cart, Book book) {
        return null;
    }

    @Override
    public int countSum(Cart cart, Book book, int uId) {
        return 0;
    }
}

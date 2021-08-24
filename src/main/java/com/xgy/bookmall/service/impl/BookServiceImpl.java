package com.xgy.bookmall.service.impl;

import com.xgy.bookmall.entity.Book;
import com.xgy.bookmall.mapper.BookMapper;
import com.xgy.bookmall.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAll(int p) {
        return bookMapper.findAll(p);
    }

    @Override
    public int getTotNum() {
        return bookMapper.getTotNum();
    }

    @Override
    public Book showDetail(int bId) {
        return bookMapper.showDetail(bId);
    }

    @Override
    public List<Book> searchByKey(int p, String key) {
        return bookMapper.searchByKey(p, key);
    }

    @Override
    public int getTotNumByKey(String key) {
        return bookMapper.getTotNumByKey(key);
    }

    @Override
    public List<Book> searchByTags(int p, String tags) {
        return bookMapper.searchByTags(p, tags);
    }

    @Override
    public int getTotNumByTags(String tags) {
        return bookMapper.getTotNumByTags(tags);
    }
}

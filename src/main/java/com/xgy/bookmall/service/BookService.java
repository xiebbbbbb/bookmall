package com.xgy.bookmall.service;

import com.xgy.bookmall.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> findAll(@Param("p") int p);
    int getTotNum();
    Book showDetail(@Param("bId") int bId);
    List<Book> searchByKey(@Param("p") int p, @Param("key") String key);
    int getTotNumByKey(String key);
//    List<Book> searchByTags(@Param("p") int p, @Param("tags") String tags);
//    int getTotNumByTags(String tags);
    List<Book> searchByTags(@Param("p") int p, @Param("tagsInfo") List<String> tagsInfo);
    //int getTotNumByTags(String tags);
    int getTotNumByTags(@Param("tagsInfo") List<String> tagsInfo);
}

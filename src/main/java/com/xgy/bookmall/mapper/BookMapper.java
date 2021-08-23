package com.xgy.bookmall.mapper;

import com.xgy.bookmall.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> findAll(@Param("p") int p);
    int getTotNum();
    Book showDetail(@Param("bId") int bId);
    List<Book> searchByKey(@Param("p") int p, @Param("key") String key);
}

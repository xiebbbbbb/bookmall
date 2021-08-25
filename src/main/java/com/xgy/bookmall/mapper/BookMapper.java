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
    int getTotNumByKey(@Param("key") String key);
    List<Book> searchByTags(@Param("p") int p, @Param("tagsInfo") List<String> tagsInfo);
    int getTotNumByTags(@Param("tagsInfo") List<String> tagsInfo);
    List<Book> searchByTagsAndKey(@Param("p") int p, @Param("tagsInfo") List<String> tagsInfo, @Param("key") String key);
    int getTotNumByTagsAndKey(@Param("tagsInfo") List<String> tagsInfo, @Param("key") String key);
}

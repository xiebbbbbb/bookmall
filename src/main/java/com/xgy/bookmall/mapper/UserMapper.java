package com.xgy.bookmall.mapper;

import com.xgy.bookmall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

//    User findUserById(@Param("uId") int uId);
//
//    List<User> findUsersByName(@Param("uName") String uName);
//
//    int insert(@Param("uName") String uName, @Param("uPwd") String uPwd, @Param("uPhone") String uPhone);

    int insert(@Param("user") User user);
    List<User> selectByNameAndPwd(@Param("uName") String uName, @Param("uPwd") String uPwd);
}

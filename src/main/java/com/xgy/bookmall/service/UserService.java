package com.xgy.bookmall.service;

import com.xgy.bookmall.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    User findUserById(@Param("uId") int uId);

    List<User> findUsersByName(@Param("uName") String uName);

    int insert(@Param("uName") String uName, @Param("uPwd") String uPwd, @Param("uPhone") String uPhone);

}

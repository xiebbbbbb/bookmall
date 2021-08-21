package com.xgy.bookmall.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

// https://projectlombok.org/features/all
// 可以找到该注释的意思
@Data
@NoArgsConstructor
public class User {
    private int uId;
    private String uName;
    private String uPwd;
    private String uPhone;

    public User(int uId, String uName, String uPwd, String uPhone) {
        this.uId = uId;
        this.uName = uName;
        this.uPwd = uPwd;
        this.uPhone = uPhone;
    }
}

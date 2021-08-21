package com.xgy.bookmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xgy.bookmall.mapper")  // 扫描mapper
@SpringBootApplication                  // 什么作用？
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

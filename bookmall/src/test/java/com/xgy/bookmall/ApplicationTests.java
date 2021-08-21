package com.xgy.bookmall;

import com.xgy.bookmall.entity.User;
import com.xgy.bookmall.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void test() throws Exception {
        List<User> users = userMapper.findUsersByName("lhh");
        for (User user: users) {
            System.out.println(user.getUId());
        }
    }

}

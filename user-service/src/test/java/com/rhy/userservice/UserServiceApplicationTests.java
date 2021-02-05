package com.rhy.userservice;

import com.rhy.mapperservice.entity.User;
import com.rhy.mapperservice.mapper.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        long l = System.currentTimeMillis();
        System.out.println(userDao.getByDOForRoles(new User().setUseName("admin")));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

}

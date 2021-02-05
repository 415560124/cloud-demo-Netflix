package com.rhy.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.mapperservice.entity.User;
import com.rhy.mapperservice.mapper.UserDao;
import com.rhy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User getByDOForRoles(User user) {
        return userDao.getByDOForRoles(user);
    }

    @Override
    public User getByUserNameForRoles(String userName) {
        return getByDOForRoles(new User().setUseName(userName));
    }
}

package com.rhy.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rhy.mapperservice.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
public interface UserService extends IService<User> {
    /**
     * 按DO查询用户、角色全部信息
     * @param user
     * @return
     */
    User getByDOForRoles(User user);

    /**
     * 按用户名查询用户、角色全部信息
     * @param user
     * @return
     */
    User getByUserNameForRoles(String userName);
}

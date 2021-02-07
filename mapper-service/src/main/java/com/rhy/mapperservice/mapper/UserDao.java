package com.rhy.mapperservice.mapper;

import com.rhy.mapperservice.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 按DO查询
     * @param user
     * @return
     */
    User getByDOForRoles(User user);
}

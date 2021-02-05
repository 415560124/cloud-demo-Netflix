package com.rhy.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.mapperservice.entity.UserRole;
import com.rhy.mapperservice.mapper.UserRoleDao;
import com.rhy.userservice.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}

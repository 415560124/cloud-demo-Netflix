package com.rhy.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.mapperservice.entity.Role;
import com.rhy.mapperservice.mapper.RoleDao;
import com.rhy.userservice.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}

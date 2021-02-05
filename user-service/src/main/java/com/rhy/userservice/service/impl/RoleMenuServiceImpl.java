package com.rhy.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.mapperservice.entity.RoleMenu;
import com.rhy.mapperservice.mapper.RoleMenuDao;
import com.rhy.userservice.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao, RoleMenu> implements RoleMenuService {

}

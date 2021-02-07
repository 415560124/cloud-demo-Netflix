package com.rhy.mapperservice.mapper;

import com.rhy.mapperservice.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 Mapper 接口
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
public interface RoleMenuDao extends BaseMapper<RoleMenu> {
    /**
     * 按DO查询角色列表
     * @param roleMenu
     * @return
     */
    List<RoleMenu> listByDOAndMenu(RoleMenu roleMenu);
}

package com.rhy.mapperservice.mapper;

import com.rhy.mapperservice.entity.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
public interface UserRoleDao extends BaseMapper<UserRole> {
    /**
     * 按DO查询关联列表
     * @param userRole
     * @return
     */
    List<UserRole> listByDOAndRole(UserRole userRole);

}

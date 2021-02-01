package com.rhy.mapperservice.mapper;

import com.rhy.mapperservice.entity.MemberInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员信息表 Mapper 接口
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
public interface MemberInfoDao extends BaseMapper<MemberInfo> {
    /**
     * 按DO查询用户信息
     * @param memberInfo
     * @return
     */
    MemberInfo getByDO(MemberInfo memberInfo);
}

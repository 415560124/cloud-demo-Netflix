package com.rhy.mapperservice.mapper;

import com.rhy.mapperservice.entity.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 订单信息 Mapper 接口
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
public interface OrderInfoDao extends BaseMapper<OrderInfo> {
    /**
     * 按DO查询用户信息列表
     * @param orderInfo
     * @return
     */
    List<OrderInfo> listByDO(OrderInfo orderInfo);
}

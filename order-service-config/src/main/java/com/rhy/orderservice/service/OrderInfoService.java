package com.rhy.orderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rhy.mapperservice.entity.OrderInfo;

import java.util.List;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
public interface OrderInfoService extends IService<OrderInfo> {
    /**
     * 按DAO查询用户订单列表
     * @param orderInfo
     * @return
     */
    List<OrderInfo> listByDO(OrderInfo orderInfo);

    /**
     * 按会员Id查询订单信息
     * @param memId
     * @return
     */
    List<OrderInfo> listByMemId(Integer memId);
}

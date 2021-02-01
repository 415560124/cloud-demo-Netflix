package com.rhy.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.mapperservice.entity.OrderInfo;
import com.rhy.mapperservice.mapper.OrderInfoDao;
import com.rhy.orderservice.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoDao, OrderInfo> implements OrderInfoService {
    @Resource
    OrderInfoDao orderInfoDao;

    @Override
    public List<OrderInfo> listByDO(OrderInfo orderInfo) {
        return orderInfoDao.listByDO(orderInfo);
    }

    @Override
    public List<OrderInfo> listByMemId(Integer memId) {
        return listByDO(new OrderInfo().setMemId(memId));
    }
}

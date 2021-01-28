package com.rhy.memberservice.api;

import com.rhy.memberservice.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年01月28日 16:45:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 订单服务Feign API ，fallback失败回调
 */
@Component
public class OrderServiceFeignFallBack implements OrderServiceFeign{
    /**
     * fallback失败时执行的方法
     * @param memId
     * @return
     */
    @Override
    public List<Order> listOrder(Integer memId) {
        return null;
    }
}

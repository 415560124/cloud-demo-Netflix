package com.rhy.memberservice.api;

import com.rhy.memberservice.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年01月28日 16:16:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 订单服务Feign API
 */
@FeignClient(value = "order-service" ,
        /*fallback = OrderServiceFeignFallBack.class*/
        fallbackFactory = OrderServiceFeignFallbackFactory.class
)
public interface OrderServiceFeign {
    @GetMapping("/orders/member/{memId}")
    List<Order> listOrder(@PathVariable Integer memId);
}

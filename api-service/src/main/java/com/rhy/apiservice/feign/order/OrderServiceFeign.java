package com.rhy.apiservice.feign.order;

import com.rhy.commonservice.entity.vo.order.OrderVO;
import com.rhy.commonservice.entity.vo.orderinfo.OrderInfoForListByVO;
import com.rhy.commonservice.util.result.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
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
    List<OrderVO> listOrder(@PathVariable Integer memId);
    @GetMapping("/orderInfos/member/{memId}")
    ResponseEntity<CommonResult<List<OrderInfoForListByVO>>> listByMemId(@PathVariable Integer memId);
}

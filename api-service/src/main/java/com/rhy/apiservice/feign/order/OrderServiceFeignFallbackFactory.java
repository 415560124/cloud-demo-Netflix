package com.rhy.apiservice.feign.order;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: Herion Lemon
 * @date: 2021年01月28日 17:16:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 订单服务Feign API 失败回调工厂
 */
@Component
@Slf4j
public class OrderServiceFeignFallbackFactory implements FallbackFactory<OrderServiceFeign> {

    private OrderServiceFeignFallBack orderServiceFeignFallBack;

    public OrderServiceFeignFallbackFactory(OrderServiceFeignFallBack orderServiceFeignFallBack) {
        this.orderServiceFeignFallBack = orderServiceFeignFallBack;
    }

    /**
     * 传入Feign调用返回的异常信息，在这里可以获得更多异常信息
     * @param throwable
     * @return
     */
    @Override
    public OrderServiceFeign create(Throwable throwable) {
        //可以封装异常处理
        log.error("fallback; exception was: {}", throwable.toString());
        log.error("fallback; reason was: {}", throwable.getMessage());
        ThreadLocal<String> errormsg = new ThreadLocal<>();
        errormsg.set(throwable.getMessage());
        //返回异常处理的类
        return this.orderServiceFeignFallBack.setErrormsg(errormsg);
    }
}

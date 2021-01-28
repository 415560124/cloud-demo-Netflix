package com.rhy.memberservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.rhy.memberservice.entity.Member;
import com.rhy.memberservice.entity.Order;
import com.rhy.memberservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年01月28日 10:31:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 会员信息服务实现类
 */
@Service
//针对于类级别的熔断降级微调
@DefaultProperties(
        defaultFallback = "defaultFallback",
        commandProperties = {
            //把熔断超时时间改为4s
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
        }
)
public class MemberServiceImpl implements MemberService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getByMemIdForError",
            commandProperties = {
                    //把熔断超时时间改为2s
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500"),
                    //熔断降级后休眠时间为2s
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "20000")
            }
    )
    @Override
    public Member getByMemId(Integer memId) {
        //给订单服务发送请求
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://order-service:2200/orders/member/{1}",String.class,memId);
        //序列化响应的json字符串
        List<Order> orders = JSONObject.parseArray(responseEntity.getBody(),Order.class);
        return new Member(memId,"张三"+memId,"17502419549").setOrders(orders);
    }

    @Override
    public Member getByMemIdForError(Integer memId) {
        return new Member(memId,"getByMemIdForError - 错误的张三"+memId,"17502419549");
    }

    @HystrixCommand
    @Override
    public Member getByMemId(Integer memId, Integer orderId) {
        //给订单服务发送请求
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://order-service:2200/orders/member/{1}",String.class,memId);
        //序列化响应的json字符串
        List<Order> orders = JSONObject.parseArray(responseEntity.getBody(),Order.class);
        return new Member(memId,orderId+"张三"+memId,"17502419549").setOrders(orders);
    }

    @Override
    public Member defaultFallback(){
        return new Member(1,"defaultFallback - 错误的张三","17502419549");
    }

}

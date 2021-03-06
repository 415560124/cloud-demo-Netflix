package com.rhy.memberservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.rhy.memberservice.api.OrderServiceFeign;
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
public class MemberServiceImpl implements MemberService {
    @Autowired
    OrderServiceFeign orderServiceFeign;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Member getByMemId(Integer memId) {
        //给订单服务发送请求
        List<Order> orders = orderServiceFeign.listOrder(memId);
        return new Member(memId,"张三"+memId,"17502419549").setOrders(orders);
    }

    @Override
    public Member getByMemIdForError(Integer memId) {
        return new Member(memId,"getByMemIdForError - 错误的张三"+memId,"17502419549");
    }

    @Override
    public Member getByMemId(Integer memId, Integer orderId) {
        //给订单服务发送请求
        List<Order> orders = orderServiceFeign.listOrder(memId);
        return new Member(memId,orderId+"张三"+memId,"17502419549").setOrders(orders);
    }

    @Override
    public Member defaultFallback(){
        return new Member(1,"defaultFallback - 错误的张三","17502419549");
    }

}

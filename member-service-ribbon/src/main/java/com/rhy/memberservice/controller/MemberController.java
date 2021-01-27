package com.rhy.memberservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.rhy.memberservice.entity.Member;
import com.rhy.memberservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021/1/26 21:43
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 会员信息相关接口
 */
@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    RestTemplate restTemplate;
    /**
     * 测试查找会员信息接口
     * @param memId
     * @return
     */
    @GetMapping("/member/{memId}")
    public Member getMember(@PathVariable Integer memId){
        //给订单服务发送请求
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://order-service:2200/orders/member/{1}",String.class,memId);
        //序列化响应的json字符串
        List<Order> orders = JSONObject.parseArray(responseEntity.getBody(),Order.class);
        return new Member(memId,"张三"+memId,"17502419549").setOrders(orders);
    }

}

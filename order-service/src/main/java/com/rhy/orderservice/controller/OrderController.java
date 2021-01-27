package com.rhy.orderservice.controller;

import com.rhy.orderservice.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @author: Herion Lemon
 * @date: 2021/1/26 21:56
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 订单信息相关接口
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping("/order/{ordId}")
    public Order getOrder(@PathVariable Integer ordId){
        return new Order(
                ordId,
                new Random().nextInt(100),
                "张三",
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
                new BigDecimal(new Random().nextInt(1000))
        );
    }
}

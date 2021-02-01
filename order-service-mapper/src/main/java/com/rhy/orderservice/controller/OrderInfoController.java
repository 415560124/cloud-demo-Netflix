package com.rhy.orderservice.controller;


import com.rhy.commonservice.entity.vo.order.OrderVO;
import com.rhy.commonservice.entity.vo.orderinfo.OrderInfoForListByVO;
import com.rhy.commonservice.util.result.CommonResult;
import com.rhy.mapperservice.entity.OrderInfo;
import com.rhy.orderservice.service.OrderInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单信息 前端控制器
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/orderInfos")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 按会员ID查询订单列表信息
     * @param memId
     * @return
     */
    @GetMapping("/member/{memId}")
    public ResponseEntity<CommonResult<List<OrderInfoForListByVO>>> listByMemId(@PathVariable Integer memId){
        List<OrderInfoForListByVO> res = new ArrayList<>();
        orderInfoService.listByMemId(memId).stream().forEach(orderInfo -> {
            OrderInfoForListByVO orderInfoForListByVO = new OrderInfoForListByVO();
            BeanUtils.copyProperties(orderInfo,orderInfoForListByVO);
            res.add(orderInfoForListByVO);
        });

        return ResponseEntity.ok(CommonResult.success(res));
    }
}


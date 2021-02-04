package com.rhy.memberservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rhy.apiservice.feign.order.OrderServiceFeign;
import com.rhy.commonservice.entity.vo.orderinfo.OrderInfoForListByVO;
import com.rhy.commonservice.util.result.CommonResult;
import com.rhy.mapperservice.entity.MemberInfo;
import com.rhy.mapperservice.entity.OrderInfo;
import com.rhy.mapperservice.mapper.MemberInfoDao;
import com.rhy.memberservice.service.MemberInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年02月01日 13:44:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 用户信息实现类
 */
@Service
public class MemberInfoServiceImpl extends ServiceImpl<MemberInfoDao, MemberInfo> implements MemberInfoService {
    @Autowired
    private MemberInfoDao memberInfoDao;
    @Autowired
    private OrderServiceFeign orderServiceFeign;
    @Override
    public MemberInfo getByDO(MemberInfo memberInfo) {
        return memberInfoDao.getByDO(memberInfo);
    }

    @Override
    public MemberInfo getByMemId(Integer memId) {
        return getByDO(new MemberInfo().setMemId(memId));
    }

    @Override
    public MemberInfo getMemberInfoAndOrderInfosByMemId(Integer memId) {
        ResponseEntity<CommonResult<List<OrderInfoForListByVO>>> commonResultResponseEntity = orderServiceFeign.listByMemId(memId);
        List<OrderInfo> orderInfos = new ArrayList<>();
        commonResultResponseEntity.getBody().getData().stream().forEach(orderInfoForListByVO -> {
            OrderInfo orderInfo = new OrderInfo();
            BeanUtils.copyProperties(orderInfoForListByVO,orderInfo);
            orderInfos.add(orderInfo);
        });
        return getByMemId(memId).setOrderInfos(orderInfos);
    }
}

package com.rhy.memberservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rhy.commonservice.entity.vo.orderinfo.OrderInfoForListByVO;
import com.rhy.mapperservice.entity.MemberInfo;
import com.rhy.mapperservice.entity.OrderInfo;

import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年02月01日 13:44:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 用户信息服务接口
 */
public interface MemberInfoService extends IService<MemberInfo> {
    /**
     * 按DO查询会员信息
     * @return
     */
    MemberInfo getByDO(MemberInfo memberInfo);

    /**
     * 按会员ID查询会员信息
     * @param memId
     * @return
     */
    MemberInfo getByMemId(Integer memId);

    /**
     * 按会员id查询会员信息及订单信息
     * @param memId
     * @return
     */
    MemberInfo getMemberInfoAndOrderInfosByMemId(Integer memId);
}

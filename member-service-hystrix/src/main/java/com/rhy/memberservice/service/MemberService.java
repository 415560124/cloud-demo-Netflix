package com.rhy.memberservice.service;

import com.rhy.memberservice.entity.Member;

/**
 * @author: Herion Lemon
 * @date: 2021年01月28日 10:31:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 会员信息服务
 */
public interface MemberService {
    /**
     * 按会员ID获取会员信息
     * @param memId
     * @return
     */
    Member getByMemId(Integer memId);

    /**
     * 按会员ID获取会员信息，异常情况
     * 参数和返回值必须相同
     * @param memId
     * @return
     */
    Member getByMemIdForError(Integer memId);

    /**
     * 按会员ID及订单ID获取会员信息
     * @param memId
     * @param orderId
     * @return
     */
    Member getByMemId(Integer memId, Integer orderId);
    /**
     * 类级别的统一异常处理
     * @param memId
     * @param orderId
     * @return
     */
    Member defaultFallback();
}

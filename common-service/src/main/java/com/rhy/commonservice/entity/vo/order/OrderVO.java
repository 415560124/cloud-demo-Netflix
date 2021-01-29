package com.rhy.commonservice.entity.vo.order;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author: Heroin
 * @date: 2021/1/26 21:58
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 会员信息DAO
 */
@Data
@Accessors(chain = true)
public class OrderVO {
    public OrderVO(Integer ordId, Integer memId, String memName, String ordCode, BigDecimal money) {
        this.ordId = ordId;
        this.memId = memId;
        this.memName = memName;
        this.ordCode = ordCode;
        this.money = money;
    }

    private Integer ordId;
    private Integer memId;
    private String memName;
    private String ordCode;
    private BigDecimal money;
}
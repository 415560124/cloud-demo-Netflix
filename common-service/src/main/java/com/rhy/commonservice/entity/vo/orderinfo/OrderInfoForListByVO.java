package com.rhy.commonservice.entity.vo.orderinfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
@Data
@Accessors(chain = true)
public class OrderInfoForListByVO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    private Integer ordId;

    /**
     * 会员id
     */
    private Integer memId;

    /**
     * 会员名
     */
    private String memName;

    /**
     * 订单编码
     */
    private String ordCode;

    /**
     * 订单总计
     */
    private BigDecimal ordMoney;


}

package com.rhy.mapperservice.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class OrderInfo implements Serializable {

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

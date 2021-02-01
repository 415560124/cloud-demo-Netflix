package com.rhy.mapperservice.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员信息表
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
@Data
@Accessors(chain = true)
public class MemberInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    private Integer memId;

    /**
     * 会员名称
     */
    private String memName;

    /**
     * 会员手机号
     */
    private String memPhone;

    /**
     * 会员订单信息集合
     */
    private List<OrderInfo> orderInfos;

}

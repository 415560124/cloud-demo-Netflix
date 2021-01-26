package com.rhy.memberservice.entity;

import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author: Herion Lemon
 * @date: 2021/1/26 21:44
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 会员信息DAO
 */
@Data
@Accessors(chain = true)
public class Member {
    public Member(Integer memId, String memName, String memPhone) {
        this.memId = memId;
        this.memName = memName;
        this.memPhone = memPhone;
    }

    private Integer memId;
    private String memName;
    private String memPhone;
}

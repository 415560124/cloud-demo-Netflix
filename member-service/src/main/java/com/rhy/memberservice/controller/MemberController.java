package com.rhy.memberservice.controller;

import com.rhy.memberservice.entity.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Herion Lemon
 * @date: 2021/1/26 21:43
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 会员信息相关接口
 */
@RestController
@RequestMapping("/members")
public class MemberController {
    /**
     * 测试查找会员信息接口
     * @param memId
     * @return
     */
    @GetMapping("/member/{memId}")
    public Member getMember(@PathVariable Integer memId){
        return new Member(memId,"任鸿毅"+memId,"17502417921");
    }

}

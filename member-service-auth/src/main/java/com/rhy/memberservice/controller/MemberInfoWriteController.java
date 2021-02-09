package com.rhy.memberservice.controller;


import com.rhy.commonservice.util.result.CommonResult;
import com.rhy.mapperservice.entity.MemberInfo;
import com.rhy.memberservice.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 会员信息表 前端控制器
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-01
 */
@RestController
@RequestMapping("/memberInfosWrite")
public class MemberInfoWriteController {
    @Autowired
    private MemberInfoService memberInfoService;

    /**
     * 按用户ID获取用户信息
     * @param memId
     * @return
     */
    @GetMapping("/memberInfo/{memId}")
    public ResponseEntity<CommonResult<MemberInfo>> getByMemId(@PathVariable Integer memId){
        return ResponseEntity.ok(CommonResult.success(memberInfoService.getMemberInfoAndOrderInfosByMemId(memId)));
    }
}


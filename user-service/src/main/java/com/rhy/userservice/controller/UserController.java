package com.rhy.userservice.controller;


import com.rhy.commonservice.util.result.CommonResult;
import com.rhy.mapperservice.entity.User;
import com.rhy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Herion Lemon
 * @since 2021-02-05
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/user/{userName}/roles")
    public CommonResult<User> getByUserNameForRoles(@PathVariable String userName) {
        return CommonResult.success(userService.getByUserNameForRoles(userName));
    }
}


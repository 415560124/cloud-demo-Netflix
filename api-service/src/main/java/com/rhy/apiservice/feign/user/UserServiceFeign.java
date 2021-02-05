package com.rhy.apiservice.feign.user;

import com.rhy.commonservice.util.result.CommonResult;
import com.rhy.mapperservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Herion Lemon
 * @date: 2021年02月05日 10:58:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: 用户服务Feign接口
 */
@FeignClient("user-service")
public interface UserServiceFeign {
    @GetMapping("/users/user/{userName}/roles")
    CommonResult<User> getByUserNameAndRoles(@PathVariable String userName);
}

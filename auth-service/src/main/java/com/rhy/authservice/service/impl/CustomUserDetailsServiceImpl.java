package com.rhy.authservice.service.impl;

import com.rhy.apiservice.feign.user.UserServiceFeign;
import com.rhy.authservice.entity.CustomUserDetails;
import com.rhy.authservice.service.CustomUserDetailsService;
import com.rhy.commonservice.util.result.CommonResult;
import com.rhy.mapperservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Herion Lemon
 * @date: 2021年02月04日 13:15:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: CustomUserDetailsService服务实现类
 */
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    @Autowired
    UserServiceFeign userServiceFeign;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CommonResult<User> result = userServiceFeign.getByUserNameAndRoles(userName);
        User user = result.getData();
        if(user == null){
            throw new UsernameNotFoundException("UserName not found");
        }
        return userParseUserDetails(user);
    }

    @Override
    public UserDetails userParseUserDetails(User user) {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        user.getUserRoles().stream().forEach(userRole -> {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole().getRolName()));
        });
        return new CustomUserDetails(user.getUseId(),user.getUseName(),user.getUsePwd(),simpleGrantedAuthorities);
    }
}

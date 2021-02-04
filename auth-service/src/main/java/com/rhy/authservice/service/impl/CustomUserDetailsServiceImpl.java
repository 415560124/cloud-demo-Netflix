package com.rhy.authservice.service.impl;

import com.rhy.authservice.service.CustomUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: Herion Lemon
 * @date: 2021年02月04日 13:15:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: CustomUserDetailsService服务实现类
 */
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

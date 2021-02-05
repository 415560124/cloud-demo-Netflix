package com.rhy.authservice.service;

import com.rhy.mapperservice.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Rhy
 * @title 自定义UserDetailsService，继承UserDetailsService
 * @description 自定义UserDetailsService，继承UserDetailsService
 * @createTime 2021年02月04日 13:10:00
 * @modifier：Rhy
 * @modification_time：2021-02-04 13:10
 */
public interface CustomUserDetailsService extends UserDetailsService {
    /**
     * {@link User}转为{@link UserDetails}
     * @param user
     * @return
     */
    UserDetails userParseUserDetails(User user);
}

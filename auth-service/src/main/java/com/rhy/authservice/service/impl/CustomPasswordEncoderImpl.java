package com.rhy.authservice.service.impl;

import com.rhy.authservice.service.CustomPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: Herion Lemon
 * @date: 2021年02月04日 13:16:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description:
 */
@Service
public class CustomPasswordEncoderImpl extends BCryptPasswordEncoder implements CustomPasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return super.matches(rawPassword, encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(new CustomPasswordEncoderImpl().encode("user-service"));
    }
}

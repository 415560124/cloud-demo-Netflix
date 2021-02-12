package com.rhy.authservice.config;

import com.rhy.authservice.service.CustomPasswordEncoder;
import com.rhy.authservice.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: Herion Lemon
 * @date: 2021年02月04日 16:09:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: WebSecurityConfigurerAdapter spring security框架实现类
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 自定义密码加密校验器
     */
    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;
    /**
     * 自定义用户信息实现类
     */
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /**
     * 用户信息相关处理类
     * @return
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //是否隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(customPasswordEncoder);
        return provider;
    }
    /**
     * 登录验证上下文
     * @return
     * @throws Exception
     */
    @Bean("authenticationManager")
    public AuthenticationManager initAuthenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     * web资源安全策略配置
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/css/**", "/images/**");
    }

    /**
     * Http请求安全策略配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests().antMatchers("/assets/**", "/css/**", "/images/**" , "/user/getCurrentUser" ).permitAll().anyRequest().authenticated()
                //允许所有身份访问    loginPage：登录页url  loginProcessingUrl：登录处理url
                .and()
                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
                .permitAll();
    }

}

package com.rhy.authservice.config;

import com.rhy.authservice.service.CustomPasswordEncoder;
import com.rhy.authservice.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @author: Herion Lemon
 * @date: 2021年02月04日 10:18:00
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: AuthorizationServerConfigurerAdapter 配置类
 */
@Configuration
public class CustomAuthorizationServerConfigurerAdapter extends AuthorizationServerConfigurerAdapter {
    /**
     * 数据库数据源
     */
    @Autowired
    private DataSource dataSource;
    /**
     * 自定义用户信息实现类
     */
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    /**
     * 授权校验流程实现类
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 自定义密码加密校验器
     */
    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;


    /**
     * 客户端授权验证方式配置，token验证与获取相关配置
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //配置token获取和验证时得策略
        //isAuthenticated()代表 需要验证时带入clientId和clientSecret
        security.tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("isAuthenticated()")
                //允许客户端form表单提交
                .allowFormAuthenticationForClients();
    }

    /**
     * 客户端相关配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //启动JDBC读取客户端信息
        clients.withClientDetails(new JdbcClientDetailsService(dataSource));
        ;
    }

    /**
     * 配置token存储得处理类Manager以及存储方式用户信息实现类
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                //token引入jdbc存储
                 .tokenStore(new JdbcTokenStore(dataSource))
                //引用自己得实现类
                 .userDetailsService(customUserDetailsService);
                //自定义授权页
//                 .pathMapping("/oauth/confirm_access","/oauth/confirm_access");

    }

}


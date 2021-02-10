package com.rhy.orderservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Herion Lemon
 * @date: 2021/2/8 19:27
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: web安全配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public ResourceServerTokenServices resourceServerTokenServices(){
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        //client_id和密码
        remoteTokenServices.setClientId("order-service");
        remoteTokenServices.setClientSecret("order-service");
        remoteTokenServices.setCheckTokenEndpointUrl("http://auth-service/oauth/check_token");
        remoteTokenServices.setRestTemplate(restTemplate);
        return remoteTokenServices;
    }
    @Bean("authenticationManager")
    public AuthenticationManager initAuthenticationManager(){
        OAuth2AuthenticationManager manager = new OAuth2AuthenticationManager();
        manager.setTokenServices(resourceServerTokenServices());
        return manager;
    }
}

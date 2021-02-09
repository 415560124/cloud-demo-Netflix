package com.rhy.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Herion Lemon
 * @date: 2021/2/8 19:37
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: RestTemplate配置类
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

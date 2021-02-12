package com.rhy.apiservice.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Herion Lemon
 * @date: 2021/1/27 20:39
 * @slogan: 如果你想攀登高峰，切莫把彩虹当梯子
 * @description: Ribbon负载均衡算法配置
 */
//@Configuration
public class RibbonConfig {
    @Bean
    public IRule getIRule(){
        // 实例化你要使用的负载均衡算法
//        return new RandomRule();
        return new MyCustomRule();
    }

}

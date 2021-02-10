package com.rhy.orderservice;

import com.rhy.apiservice.ApiServiceApplication;
import com.rhy.commonservice.CommonServiceApplication;
import com.rhy.mapperservice.MapperServiceApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackageClasses = MapperServiceApplication.class)
@ComponentScan(
        basePackageClasses = {
                ApiServiceApplication.class,
                OrderServiceApplication.class,
                CommonServiceApplication.class
        }
)
@EnableResourceServer
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}

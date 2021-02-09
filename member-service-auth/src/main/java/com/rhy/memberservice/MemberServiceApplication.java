package com.rhy.memberservice;

import com.rhy.apiservice.ApiServiceApplication;
import com.rhy.commonservice.CommonServiceApplication;
import com.rhy.mapperservice.MapperServiceApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 同时存在这三个注解时：
 * @SpringBootApplication
 * @EnableDiscoveryClient
 * @EnableCircuitBreaker
 * 可以替换为一个：
 * @SpringCloudApplication
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(
        //第一种：指定以哪个类为根路径进行扫描 - 推荐
        basePackageClasses = {ApiServiceApplication.class},
        //第二种：指定包
        basePackages = "com.rhy"
)
@ComponentScan(
        //第一种：指定以哪个类为根路径进行扫描 - 推荐
        basePackageClasses = {
                ApiServiceApplication.class,
                CommonServiceApplication.class
        }
)
@MapperScan(basePackageClasses = MapperServiceApplication.class)
//@RibbonClient(name = "order-service",configuration = RibbonConfig.class)
@EnableResourceServer
public class MemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
    }

}

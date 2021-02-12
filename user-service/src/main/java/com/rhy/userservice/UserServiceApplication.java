package com.rhy.userservice;

import com.rhy.apiservice.ApiServiceApplication;
import com.rhy.commonservice.CommonServiceApplication;
import com.rhy.mapperservice.MapperServiceApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackageClasses = MapperServiceApplication.class)
@ComponentScan(
        //第一种：指定以哪个类为根路径进行扫描 - 推荐
        basePackageClasses = {
                ApiServiceApplication.class,
                CommonServiceApplication.class,
                UserServiceApplication.class
        }
)
@EnableResourceServer
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}

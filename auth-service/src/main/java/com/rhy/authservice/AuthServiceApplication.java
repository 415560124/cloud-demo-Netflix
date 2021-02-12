package com.rhy.authservice;

import com.rhy.apiservice.ApiServiceApplication;
import com.rhy.commonservice.CommonServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
@EnableFeignClients(
        //第一种：指定以哪个类为根路径进行扫描 - 推荐
        basePackageClasses = {ApiServiceApplication.class},
        //第二种：指定包
        basePackages = "com.rhy"
)
@ComponentScan(
        basePackageClasses = {
                AuthServiceApplication.class,
                CommonServiceApplication.class
        }
)
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}

package com.rhy.authservice;

import com.rhy.apiservice.ApiServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableFeignClients(
        //第一种：指定以哪个类为根路径进行扫描 - 推荐
        basePackageClasses = {ApiServiceApplication.class},
        //第二种：指定包
        basePackages = "com.rhy"
)
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

}

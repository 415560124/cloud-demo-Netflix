package com.rhy.memberservice;

import com.rhy.apiservice.ApiServiceApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 同时存在这三个注解时：
 * @SpringBootApplication
 * @EnableDiscoveryClient
 * @EnableCircuitBreaker
 * 可以替换为一个：
 * @SpringCloudApplication
 */
@SpringCloudApplication
@EnableFeignClients(
        //第一种：指定以哪个类为根路径进行扫描 - 推荐
        basePackageClasses = {ApiServiceApplication.class},
        //第二种：指定包
        basePackages = "com.rhy"
)
@ComponentScan("com.rhy")
//@RibbonClient(name = "order-service",configuration = RibbonConfig.class)
public class MemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
    }

}

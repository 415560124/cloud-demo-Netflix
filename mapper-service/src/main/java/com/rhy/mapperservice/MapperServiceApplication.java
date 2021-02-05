package com.rhy.mapperservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = MapperServiceApplication.class)
public class MapperServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapperServiceApplication.class, args);
    }

}

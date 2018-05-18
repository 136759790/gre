package com.gre.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan(basePackages={"com.gre"})
public class AppSys {
    public static void main( String[] args ){
        SpringApplication.run(AppSys.class, args);
    }
}

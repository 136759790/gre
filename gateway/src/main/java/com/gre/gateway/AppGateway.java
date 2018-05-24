package com.gre.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan(basePackages="com.gre")
public class AppGateway {
    public static void main( String[] args ){
       SpringApplication.run(AppGateway.class, args);
    }
}

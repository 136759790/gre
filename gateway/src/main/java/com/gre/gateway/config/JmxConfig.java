package com.gre.gateway.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport(defaultDomain="com.gre")
@ComponentScan(basePackages="com.gre")
public class JmxConfig {

}

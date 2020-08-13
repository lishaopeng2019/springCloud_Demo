package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 启动类，启动时默认扫描所在包及子包下的注解去初始化Bean
 */
@SpringBootApplication
@EnableDiscoveryClient // @EnableEurekaClient只适用于Eureka作为注册中心;@EnableDiscoveryClient 可以是其他注册中心
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

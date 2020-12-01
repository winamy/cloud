package com.winamy.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: wym
 * @date: 2020/8/19
 **/
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.winamy"})
@EnableFeignClients(basePackages = {"com.winamy"})
public class NacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class, args);
    }
}

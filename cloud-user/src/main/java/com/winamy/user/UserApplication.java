package com.winamy.user;

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
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

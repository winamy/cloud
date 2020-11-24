package com.winamy.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wym
 * @date: 2020/8/21
 **/
@RestController
@RequestMapping
public class GatewayController {

    /**
     * 配置的熔断回调地址
     * @return
     */
    @RequestMapping(value = "/fallback")
    public String fallback(){
        return "fallback nothing";
    }

}

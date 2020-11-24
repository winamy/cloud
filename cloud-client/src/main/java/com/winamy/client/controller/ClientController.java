package com.winamy.client.controller;

import com.winamy.common.models.Result;
import com.winamy.provider.interfaces.IProviderApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: wym
 * @date: 2020/8/20
 **/
@Slf4j
@RestController
@RequestMapping("/client")
public class ClientController {

    @Resource
    private IProviderApi providerApi;

    @RequestMapping("/say")
    public Result<String> say(){
        log.info("调用prodiver开始");
        return providerApi.sayHello();
    }
}

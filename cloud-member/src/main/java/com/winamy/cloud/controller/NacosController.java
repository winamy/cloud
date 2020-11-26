package com.winamy.cloud.controller;

import com.winamy.common.models.Result;
import com.winamy.common.utils.ResultUtil;
import com.winamy.provider.interfaces.IProviderApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: wym
 * @date: 2020/8/19
 **/
@RefreshScope
@RestController
@RequestMapping("/test")
public class NacosController implements IProviderApi {

    @Value("${test.say}")
    private String name;

    @RequestMapping("/sayHello")
    @Override
    public Result<String> sayHello() {
        return ResultUtil.success("hello," + name +"!");
    }
}

package com.winamy.provider.interfaces;

import com.winamy.common.models.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 服务提供者API
 * @author: wym
 * @date: 2020/8/20
 **/
@FeignClient(value = "cloud-provider")
public interface IProviderApi {

    @RequestMapping("/test/sayHello")
    Result<String> sayHello();
}

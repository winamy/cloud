package com.winamy.service.common.annotations;

import java.lang.annotation.*;

/**
 * @description: 返回结果统一处理注解
 * @author: wym
 * @date: 2020/11/26
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface ResponseResult {

}

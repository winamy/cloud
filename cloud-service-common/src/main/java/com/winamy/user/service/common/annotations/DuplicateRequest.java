package com.winamy.user.service.common.annotations;

import java.lang.annotation.*;

/**
 * @description: 处理重复请求注解
 * @author: wym
 * @createDate: 2020/12/1
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface DuplicateRequest {
    /**
     * 过期时间,单位毫秒
     * @return
     */
    long expireTime() default 1000;

    /**
     * 过滤字段
     * @return
     */
    String[] excludeField() default "";

//    /**
//     * 包含字段,为空时比较除了过滤字段的全部参数
//     * @return
//     */
//    String[] includeField() default "";
}

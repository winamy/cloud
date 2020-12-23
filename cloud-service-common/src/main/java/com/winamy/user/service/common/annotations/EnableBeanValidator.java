package com.winamy.user.service.common.annotations;

import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;

import java.lang.annotation.*;

/**
 * @author : wym
 * @description swagger注解
 * @date : 2020/12/7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(BeanValidatorPluginsConfiguration.class)
public @interface EnableBeanValidator {
}

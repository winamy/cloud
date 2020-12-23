package com.winamy.user.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.winamy.user.service.common.annotations.EnableBeanValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : wym
 * @description https://blog.csdn.net/qq_27087671/article/details/104725452
 * @date : 2020/12/7
 */
@Configuration
@EnableKnife4j
@EnableSwagger2
@EnableBeanValidator
public class SwaggerConfiguration {
    @Bean(value = "userApi")
    @Order(value = 1)
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.xf.member"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder() .title("member接口")
                .description("member接口").termsOfServiceUrl("http://localhost:7070/") .contact(new Contact("fangxiaofan", "" , "4582841895@qq.com"))
                .version("1.0") .build();
    }
}

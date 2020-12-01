package com.winamy.user.service.common.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.winamy.user.service.common.mybatisPlus.ExtSqlInjector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: mybatis-plus配置
 * @author: wym
 * @date: 2020/11/25
 **/
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 自定义方法
     * @return
     */
    @Bean
    public ExtSqlInjector extSqlInjector(){
        return new ExtSqlInjector();
    }

    /**
     * 控制版本号
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}

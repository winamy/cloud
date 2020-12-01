package com.winamy.user.service.common.interceptors;

import com.winamy.common.constants.CommonConstants;
import com.winamy.user.service.common.annotations.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @description: 返回结果统一处理拦截器
 * @author: wym
 * @date: 2020/11/26
 **/
@Component
@Slf4j
public class ResponseResultInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
           final HandlerMethod handlerMethod = (HandlerMethod) handler;
           final Class<?> clazz = handlerMethod.getBeanType();
           final Method method = handlerMethod.getMethod();
           if(clazz.isAnnotationPresent(ResponseResult.class)){
               request.setAttribute(CommonConstants.RESPONSE_RESULT_FLAG, clazz.getAnnotation(ResponseResult.class));
           } else if(method.isAnnotationPresent(ResponseResult.class)){
               request.setAttribute(CommonConstants.RESPONSE_RESULT_FLAG, method.getAnnotation(ResponseResult.class));
           }
        }
        return true;
    }
}

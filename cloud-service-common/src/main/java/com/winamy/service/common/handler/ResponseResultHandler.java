package com.winamy.service.common.handler;

import com.winamy.common.constants.CommonConstants;
import com.winamy.common.models.ErrorResult;
import com.winamy.common.models.Result;
import com.winamy.service.common.annotations.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @description: 返回结果统一处理器
 * @author: wym
 * @date: 2020/11/26
 **/
@ControllerAdvice
@Slf4j
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    //请求是否包含了 返回结果统一处理 标识，如果没有，不需要重写返回体
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        ResponseResult responseResultAno = (ResponseResult) request.getAttribute(CommonConstants.RESPONSE_RESULT_FLAG);
        return responseResultAno == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ErrorResult){
            ErrorResult errorResult = (ErrorResult) body;
            return Result.fail(errorResult.getCode(),errorResult.getMsg());
        }
        return Result.ok(body);
    }
}

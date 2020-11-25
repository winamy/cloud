package com.winamy.exception.enums;

import com.winamy.exception.interfaces.IExceptionEnum;

/**
 * @description: servlet异常
 * @author: wym
 * @date: 2020/6/12
 **/
public enum ServletExceptionEnum implements IExceptionEnum {
    NoHandlerFoundException(1001, "没有找到对应的控制器"),
    HttpRequestMethodNotSupportedException(1002, "没有找到对应的请求方法"),
    HttpMediaTypeNotSupportedException(1003, "请求头不匹配异常"),
    MissingPathVariableException(1004, "未检测到路径参数"),
    MissingServletRequestParameterException(1005, "缺少请求参数异常"),
    TypeMismatchException(1006, "参数类型匹配异常"),
    HttpMessageNotReadableException(1007, "消息不能正常解读异常"),
    HttpMessageNotWritableException(1008, "序列化异常");

    private int code;

    private String msg;

    ServletExceptionEnum(int code, String msg){
        this.code =code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}

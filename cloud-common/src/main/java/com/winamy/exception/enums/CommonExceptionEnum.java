package com.winamy.exception.enums;

import com.winamy.exception.interfaces.IExceptionEnum;
import com.winamy.exception.exceptions.BaseException;

/**
 * @description: 常见通用异常枚举   100-999
 * @author: wym
 * @date: 2020/8/20
 **/
public enum CommonExceptionEnum implements IExceptionEnum {
    SERVER_ERROR(100,"系统繁忙，请稍后再试"),
    TIMEOUT(101,"时间超时，请重试"),
    PARAMETER_NOT_FOUND(102,"参数不存在"),
    DUPLICATE_REQUEST(103,"请勿发起重复请求"),
    UNKNOWN(999,"未知异常");

    private int code;
    private String msg;

    CommonExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.getMsg();
    }

    @Override
    public BaseException newException(Object... args) {
        return null;
    }

}

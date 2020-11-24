package com.winamy.exception.exceptions;

import com.winamy.exception.interfaces.IBaseExceptionEnum;
import com.winamy.exception.interfaces.IExceptionEnum;

import java.text.MessageFormat;

/**
 * @description: 业务基础异常，所有异常继承此类即可
 * @author: wym
 * @date: 2020/8/20
 **/
public class BaseException extends RuntimeException{
    private int code;
    private String msg;
    private IBaseExceptionEnum exceptionEnum;

    public BaseException(IExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
        this.exceptionEnum = exceptionEnum;
    }

    public BaseException(IExceptionEnum exceptionEnum, Object... args){
        this.code = exceptionEnum.getCode();
        this.msg = MessageFormat.format(exceptionEnum.getMsg(), args);
        this.exceptionEnum = exceptionEnum;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

}

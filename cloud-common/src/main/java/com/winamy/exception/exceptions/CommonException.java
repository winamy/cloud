package com.winamy.exception.exceptions;

import com.winamy.exception.interfaces.IExceptionEnum;

/**
 * @description: 常见异常
 * @author: wym
 * @date: 2020/8/20
 **/
public class CommonException extends BaseException {
    public CommonException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public CommonException(IExceptionEnum exceptionEnum, Object... args) {
        super(exceptionEnum, args);
    }
}

package com.winamy.exception.exceptions;

import com.winamy.exception.interfaces.IExceptionEnum;

/**
 * @description: 业务异常
 * @author: wym
 * @date: 2020/8/20
 **/
public class BusinessException extends BaseException {
    public BusinessException(IExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }

    public BusinessException(IExceptionEnum exceptionEnum, Object... args) {
        super(exceptionEnum, args);
    }
}

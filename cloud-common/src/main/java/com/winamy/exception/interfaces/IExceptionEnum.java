package com.winamy.exception.interfaces;

import com.winamy.exception.exceptions.BaseException;

/**
 * @description: 异常枚举接口，所有异常枚举实现该接口，即拥有断言
 * @author: wym
 * @date: 2020/8/20
 **/
public interface IExceptionEnum extends IBaseExceptionAssert,IBaseExceptionEnum{

    @Override
    default BaseException newException(Object... args){
        return new BaseException(this, args);
    }

}

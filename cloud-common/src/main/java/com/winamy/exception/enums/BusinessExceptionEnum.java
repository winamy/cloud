package com.winamy.exception.enums;

import com.winamy.exception.exceptions.BaseException;
import com.winamy.exception.exceptions.BusinessException;
import com.winamy.exception.interfaces.IExceptionEnum;

/**
 * @description: 业务异常枚举 2000-3000
 * @author: wym
 * @date: 2020/8/20
 **/
public enum BusinessExceptionEnum implements IExceptionEnum {
    VALID_ERROR(1001,"参数校验异常");
    private int code;
    private String msg;

    BusinessExceptionEnum(int code,String msg){
        this.code = code;
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

    @Override
    public BaseException newException(Object... args) {
        return new BusinessException(this, args);
    }
}

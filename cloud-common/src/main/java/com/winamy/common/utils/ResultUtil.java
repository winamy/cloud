package com.winamy.common.utils;

import com.winamy.common.models.Result;

/**
 * @description: 返回结果工具类
 * @author: wym
 * @date: 2020/8/20
 **/
public class ResultUtil {
    private static int SUCCESS_CODE = 0;
    private static String SUCCESS_MSG = "请求成功";
    private static int FAIL_CODE = -1;
    private static String FAIL_MSG = "请求失败";

    public static <T> Result<T> success(T data){
        return new Result(SUCCESS_CODE, SUCCESS_MSG, data);
    }

    public static Result fail(){
        return new Result(FAIL_CODE, FAIL_MSG);
    }

    public static Result fail(String failMsg){
        return new Result(FAIL_CODE, failMsg);
    }
}

package com.winamy.common.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 统一返回结果
 * @author: wym
 * @date: 2020/11/26
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 4137772893507260981L;
    private int code = 0;
    private String msg = "请求成功";
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result ok(Object data){
        return new Result(data);
    }

    public static Result fail(int code, String msg){
        return new Result(code, msg);
    }
}

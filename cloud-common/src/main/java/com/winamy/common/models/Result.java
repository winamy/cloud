package com.winamy.common.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 返回结果
 * @author: wym
 * @date: 2020/8/20
 **/
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 4137772893507260981L;
    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}

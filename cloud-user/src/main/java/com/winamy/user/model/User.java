package com.winamy.user.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: wym
 * @date: 2020/11/25
 **/
@Data
@TableName("tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 是否删除。0未删除，1删除
     */
    @TableLogic
    private Integer isDtl;

    /**
     * 版本号
     */
    @Version
    private Integer version;
}

package com.winamy.client.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winamy.client.dao.IUserDao;
import com.winamy.client.model.User;
import com.winamy.client.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @description: 用户服务
 * @author: wym
 * @date: 2020/11/25
 **/
@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService {

}

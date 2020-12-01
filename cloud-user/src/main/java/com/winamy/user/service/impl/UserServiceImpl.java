package com.winamy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winamy.user.dao.IUserDao;
import com.winamy.user.model.User;
import com.winamy.user.service.IUserService;
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

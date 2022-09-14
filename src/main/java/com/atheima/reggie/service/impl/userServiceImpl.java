package com.atheima.reggie.service.impl;

import com.atheima.reggie.entity.User;
import com.atheima.reggie.mapper.UserMapper;
import com.atheima.reggie.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * FileName:     userServiceImpl
 * CreateBy:     IntelliJ IDEA
 * Author:       wei
 * Date:         2022-09-12
 * Description :
 */
@Service
public class userServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

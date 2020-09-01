package com.mp.commonService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mapper.UserMapper;
import com.mp.commonService.IUserService;
import com.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @program: config_demo
 * @description: 业务层实现类
 * @author: Su
 * @create: 2020-09-01 16:37
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
}

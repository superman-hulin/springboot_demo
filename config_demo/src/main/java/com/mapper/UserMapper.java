package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: config_demo
 * @description: 用户的mapper接口
 * @author: Su
 * @create: 2020-09-01 08:34
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
}

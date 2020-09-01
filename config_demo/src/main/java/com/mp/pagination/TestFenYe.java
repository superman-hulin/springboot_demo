package com.mp.pagination;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.mp.pagination.util.CommonPage;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

/**
 * @program: config_demo
 * @description: 测试分页
 * @author: Su
 * @create: 2020-09-01 08:53
 **/

public class TestFenYe {
    @Autowired
    private UserMapper userMapper;

    public CommonPage testSelectPage(){
        //构建查询条件   age大于20
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.gt("age",20);

        //构建page对象  当前页为第一页 每页显示20
        Page page=new Page(1,20);

        IPage iPage=userMapper.selectPage(page,queryWrapper);

        System.out.println("数据总条数：" + iPage.getTotal());
        System.out.println("总页数：" + iPage.getPages());
        //当前页的数据
        List<User> users = iPage.getRecords();
        for (User user : users) {
            System.out.println("user = " + user);
        }
        return CommonPage.restPage(iPage);

    }
}

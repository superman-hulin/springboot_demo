package com;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.mp.commonService.IUserService;
import com.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
class ConfigDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserService userService;
    @Test
    void contextLoads() {
    }
    @Test
    public void testSelectPage(){
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
    }

    @Test
    public void testFindAll(){
        List<User> users=userMapper.findAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    //测试通用service对数据库的操作
    @Test
    public void selectOneService() {
        QueryWrapper queryWrapper=new QueryWrapper();
        User user = userService.getOne((Wrapper<User>)queryWrapper.eq("user_name", "sad"), false);
        System.out.println(user);
    }

    //测试通用service的分页查询
    @Test
    public void selectByFenYe(Integer pageNum,Integer pageSize){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("uid",123);
        IPage<User> page = userService.page(new Page(pageNum, pageSize),queryWrapper);
        page.getRecords();
    }

}

package com.mp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: config_demo
 * @description: mp的配置类
 * @author: Su
 * @create: 2020-09-01 08:27
 **/
@Configuration
@MapperScan({"com.mapper","com.baidu.fsg.uid"})  //扫描dao接口所在的包
//"com.baidu.fsg.uid" 是扫描生成器中的相关注解
public class MybatisPlusConfig {

    @Bean //注入分页插件
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}

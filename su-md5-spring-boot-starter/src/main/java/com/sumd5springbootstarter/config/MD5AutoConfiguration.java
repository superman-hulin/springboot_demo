package com.sumd5springbootstarter.config;

import com.sumd5springbootstarter.properties.MD5Properties;
import com.sumd5springbootstarter.service.MD5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: su-md5-spring-boot-starter
 * @description: md5服务的自动配置类
 *      自制springboot-starer
 *          修改pom相关依赖
 *          编写业务逻辑，即服务 MD5Util
 *          提供一个service对服务进行封装，外部使用service进行调用
 *          编写自动配置类 xxxAutoConfiguration
 *              可编写xxxProperties，对应配置文件
 *          编写spring.factories  让springboot项目启动时可以找到自制的自动配置类，然后将服务注入到容器中
 *
 * @author: Su
 * @create: 2020-09-03 10:19
 **/
@Configuration
@EnableConfigurationProperties(MD5Properties.class)
public class MD5AutoConfiguration {
    @Autowired
    private MD5Properties md5Properties;

    @Bean
    public MD5Service md5Service(){
        MD5Service md5Service= new MD5Service();
        md5Service.setMd5Properties(md5Properties);
        return md5Service;
    }
}

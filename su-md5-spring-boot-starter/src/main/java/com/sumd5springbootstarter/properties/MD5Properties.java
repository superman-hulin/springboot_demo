package com.sumd5springbootstarter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: su-md5-spring-boot-starter
 * @description: md5服务的对应文件配置
 * @author: Su
 * @create: 2020-09-03 10:21
 **/
@ConfigurationProperties(prefix = "su.MD5")
public class MD5Properties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

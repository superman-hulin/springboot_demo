package com.sumd5springbootstarter.service;

import com.sumd5springbootstarter.properties.MD5Properties;
import com.sumd5springbootstarter.util.MD5Util;

/**
 * @program: su-md5-spring-boot-starter
 * @description: 供外使用的md5服务
 * @author: Su
 * @create: 2020-09-03 10:17
 **/
public class MD5Service {

    private MD5Properties md5Properties;

    public void setMd5Properties(MD5Properties md5Properties) {
        this.md5Properties = md5Properties;
    }

    public String getMD5(String input ) {
        System.out.println(md5Properties.getName());
        return MD5Util.getMD5( input.getBytes() );
    }
}

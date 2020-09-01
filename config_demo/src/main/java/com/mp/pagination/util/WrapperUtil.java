package com.mp.pagination.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

/**
 * @program: config_demo
 * @description: 查询条件构造器
 *      封装一些通用的查询条件构造器
 * @author: Su
 * @create: 2020-09-01 09:02
 **/
public class WrapperUtil {

    //单对查询条件
    public static QueryWrapper singleQueryWrapperBuilder(String column,Object value){
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq(column,value);
            return queryWrapper;
    }

    //多对查询条件 入参格式为map
    public static QueryWrapper mapQueryWrapperBuilder(Map<String,Object> queryMap){
        QueryWrapper queryWrapper=new QueryWrapper();
        for (String key:queryMap.keySet()){
            queryWrapper.eq(key,queryMap.get(key));
        }
        return queryWrapper;
    }

    /**
     * 根据主键与用户id联合查询
     * @return
     */
    public static QueryWrapper queryByUserIdAndPK(String id, String uid){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id", id);
        wrapper.eq("uid",uid);
        return wrapper;
    }



}

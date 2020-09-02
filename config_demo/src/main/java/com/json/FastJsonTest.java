package com.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pojo.User;

/**
 * @program: config_demo
 * @description: json常用转化
 *      json字符串  json对象  java实体类对象
 * @author: Su
 * @create: 2020-09-02 14:55
 **/
public class FastJsonTest {

    //json字符串转json对象
    public JSONObject jsonString2JsonObject(String t){
        JSONObject jsonObject=JSON.parseObject(t);
        //为该json对象扩充键值对
        jsonObject.put("a",12);
        //取值
        jsonObject.get("a");
        return jsonObject;
    }

    //json字符串转java实体类对象
    public User jsonString2JavaObject(String t){
        User user=JSON.parseObject(t,User.class);
        return user;
    }

    //json对象转java实体类对象
    public User jsonObject2JavaObject(JSONObject jsonObject){
        User user=JSON.toJavaObject(jsonObject,User.class);
        return user;
    }

    //json对象转json字符串
    public String jsonObject2JsonStringt(JSONObject jsonObject){
        String jsonString=jsonObject.toString();
        return jsonString;
    }

    //java对象转json字符串
    public String javaObject2JsonStringt(User user){
        String jsonString=JSON.toJSONString(user);
        return jsonString;
    }


}

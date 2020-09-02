package com.deferredResult;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: config_demo
 * @description: 异步请求结果的缓存
 * @author: Su
 * @create: 2020-09-02 10:59
 **/
public class DeferredResultCache {
    // 使用线程安全的Hashmap
    private static Map<String, DeferredResult> deferredResultMap = new ConcurrentHashMap<>();

    public static DeferredResult get(String actionId){
        return deferredResultMap.get(actionId);
    }

    public static void put(String actionId, DeferredResult result){
        deferredResultMap.put(actionId, result);
    }

    public static void del(String requestId){
        deferredResultMap.remove(requestId);
    }
}

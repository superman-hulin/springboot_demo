package com.deferredResult;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: config_demo
 * @description: 异步请求的service
 * @author: Su
 * @create: 2020-09-02 10:56
 **/
@Service
public class DeferredResultService {

    public DeferredResult<DeferredResultResponse> get(String actionId){
        DeferredResult result=DeferredResultBuild.build(actionId,"操作超时");
        //判断操作的条件是否满足可以立即返回，如果可以 则直接唤醒result
        if(actionId.equals("yes")){
            result.setResult(new DeferredResultResponse<String>("200","立即返回"));
            return result;
        }
        //将该异步结果存入缓存
        DeferredResultCache.put(actionId, result);
        //等待别处监听到操作完成后（一般是监听消息队列），从异步结果缓存中取该异步结果，然后唤醒后 再走完成的回调函数
        result.onCompletion(()->{
            result.getResult();
            //根据该返回结果做其它业务操作
        });
        return result;
    }
}

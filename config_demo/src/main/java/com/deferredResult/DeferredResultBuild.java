package com.deferredResult;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: config_demo
 * @description: 异步请求返回结果构造器
 *      使用DeferredResult的原因
 *          1.API接口需要在指定时间内将异步操作的结果同步返回给前端时
 *          2.Controller处理耗时任务，并且需要耗时任务的返回结果时
 *      当一个请求到达API接口，如果该API接口的return返回值是DeferredResult，在没有超时或者DeferredResult对象设置setResult时，接口不会返回
 *      但是Servlet容器线程会结束，DeferredResult另起线程来进行结果处理(即这种操作提升了服务短时间的吞吐能力)，并setResult，
 *      如此以来这个请求不会占用服务连接池太久，如果超时或设置setResult，接口会立即返回。
 *
 *      使用DeferredResult的流程：
 *         浏览器发起异步请求
 *         请求到达服务端被挂起
 *         向浏览器进行响应，分为两种情况：
 *          1 调用DeferredResult.setResult()，请求被唤醒，返回结果
 *          2 超时，返回一个你设定的结果
 *
 *      场景：
 *       浏览器向A系统发起请求，该请求需要等到B系统(如ＭＱ)给A推送数据时，A才会立刻向浏览器返回数据；
 *       如果指定时间内Ｂ未给Ａ推送数据，则返回超时
 * @author: Su
 * @create: 2020-09-02 10:58
 **/
public class DeferredResultBuild {
    /**
     * 构建一个DeferredResult
     * @param actionId 操作id
     * @param timeoutMsg 操作超时后返回的信息
     * @return
     */
    public static DeferredResult build(String actionId, String timeoutMsg){
        //定义超时时间
        DeferredResult<DeferredResultResponse> result = new DeferredResult(5000L);
        //定义超时行为，直接唤醒异步结果进行返回
        result.onTimeout(() -> {
            result.setResult(new DeferredResultResponse("400","请求超时"));
            // 删除对应键，防止python模块超时返回时占用，使缓存产生冗余
            DeferredResultCache.del(actionId);
        });
        return result;
    }
}

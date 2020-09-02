package com.deferredResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @program: config_demo
 * @description: 异步请求的controller
 * @author: Su
 * @create: 2020-09-02 10:55
 **/
@RestController
public class DeferredResultController {
    @Autowired
    private DeferredResultService deferredResultService;

    @GetMapping("/deferredResult")
    public DeferredResult<DeferredResultResponse> get(String actionId){
       return deferredResultService.get(actionId);

    }
}

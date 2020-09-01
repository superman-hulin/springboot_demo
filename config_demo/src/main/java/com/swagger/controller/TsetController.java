package com.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: config_demo
 * @description: 测试的controller
 * @author: Su
 * @create: 2020-08-31 08:06
 **/
@RestController("/test")
@Api(tags = {"测试的controller"},description = "测试controller")
public class TsetController {
    @GetMapping("/testSwagger")
    @ApiOperation("测试swagger")
    public String testSwagger(@RequestParam("name") String name){
        return "hello";
    }
}

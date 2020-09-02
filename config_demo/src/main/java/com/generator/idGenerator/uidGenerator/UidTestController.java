package com.generator.idGenerator.uidGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: config_demo
 * @description: id生成器的测试controller
 * @author: Su
 * @create: 2020-09-02 09:05
 **/
@RestController
public class UidTestController {
    @Autowired
    private UidGenService uidGenService;

    @GetMapping("/testuid")
    public String test() {
        return String.valueOf( uidGenService.getUid() );
    }
}

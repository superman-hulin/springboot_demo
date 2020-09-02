package com.generator.idGenerator.uidGenerator;

import com.baidu.fsg.uid.UidGenerator;
import com.baidu.fsg.uid.impl.CachedUidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: config_demo
 * @description: id生成器的业务类
 * @author: Su
 * @create: 2020-09-02 09:04
 **/
@Service
public class UidGenService {

    @Autowired
    @Resource(name="cachedUidGenerator")
    private UidGenerator cachedUidGenerator;

    public long getUid() {
        System.out.println(cachedUidGenerator);
        return cachedUidGenerator.getUID();
    }
}

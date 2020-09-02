package com.generator.idGenerator.uidGenerator;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @program: config_demo
 * @description: 该全局唯一id生成器的配置类
 *          github下载UidGenerator源码 然后使用maven进行打jar包以及安装到本地仓库
 *          pom文件导入坐标引入UidGenerator依赖  注意排除生成器中的一些mybatis和日志的相关依赖，会和本项目产生冲突
 *          使用WORKER_NODE.sq创建该表 该表是记录 项目中请求生成器生成的日志信息
 *          拷贝WORKER_NODE.xml到resources的mapper文件夹下 被扫描执行表的操作
 *          拷贝cached-uid-spring.xml到resources下  扫描该配置文件，将生成器中相应对象加入容器
 *          在mp配置类的@MapperScan注解中增加生成器中WORKER_NODEDAO注解的扫描，使其加入容器
 *
 * @author: Su
 * @create: 2020-09-02 09:03
 **/
@Configuration
@ImportResource(locations = {"classpath:cached-uid-spring.xml"}) //引入uid的spring配置文件
public class UidConfig {
}

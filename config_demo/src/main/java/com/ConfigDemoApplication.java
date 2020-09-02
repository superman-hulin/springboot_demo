package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
*@Description: springboot运行原理分析
 *      1. @SpringBootApplication的三体结构
 *           @SpringBootConfiguration   依赖底层@Configuration注解 表示是配置类
 *           @EnableAutoConfiguration   读取jar包中META-INF/spring.factories文件中的自动配置类的全限定名，开启一些自动配置功能
 *           @ComponentScan     扫描该启动类所在的包下以及子包的所有组件到容器中
 *      2. SpringApplication.run方法
 *           1）首先会new一个SpringApplication对象
 *                  判断应用类型（三种）
 *                  读取jar包中META-INF/spring.factories文件中的ApplicationContextInitializer和ApplicationListener类，并收集
 *           2）调用run方法所执行的步骤
                通过 SpringFactoriesLoader 加载 META-INF/spring.factories 文件，获取并创建 SpringApplicationRunListener 对象
                然后由 SpringApplicationRunListener 来发出 starting 消息
                创建参数，并配置当前 SpringBoot 应用将要使用的 Environment
                完成之后，依然由 SpringApplicationRunListener 来发出 environmentPrepared 消息
                创建 ApplicationContext
                初始化 ApplicationContext，并设置 Environment，加载相关配置等
                由 SpringApplicationRunListener 来发出 contextPrepared 消息，告知SpringBoot 应用使用的 ApplicationContext 已准备OK
                将各种 beans 装载入 ApplicationContext，继续由 SpringApplicationRunListener 来发出 contextLoaded 消息，告知 SpringBoot 应用使用的 ApplicationContext 已装填OK
                refresh ApplicationContext，完成IoC容器可用的最后一步
                由 SpringApplicationRunListener 来发出 started 消息
                完成最终的程序的启动
                由 SpringApplicationRunListener 来发出 running 消息，告知程序已运行起来了
        3. ApplicationContextInitializer作用
            ApplicationContextInitializer是Spring框架原有的东西，这个类的主要作用就是在ConfigurableApplicationContext类型(或者子类型)的ApplicationContext做refresh之前，
            允许我们对ConfiurableApplicationContext的实例做进一步的设置和处理
            classpath上会包含很多jar包，有些jar包需要在ConfigurableApplicationContext#refresh()调用之前对应用上下文做一些初始化动作，
            因此它们会提供自己的ApplicationContextInitializer实现类，然后放在自己的META-INF/spring.factories属性文件中，
            这样相应的ApplicationContextInitializer实现类就会被SpringApplication#initialize发现
        4. ApplicationListener、SpringApplicationRunListeners、SpringApplicationRunListener的关系
            SpringApplicationRunListeners类和SpringApplicationRunListener类是SpringBoot中新增的类。ApplicationListener是spring中框架的类
            SpringApplicationRunListeners是SpringApplicationRunListener的封装，SpringApplicationRunListeners中包含多个SpringApplicationRunListener，是为了批量执行的封装
            public interface SpringApplicationRunListener {
                // 在run()方法开始执行时，该方法就立即被调用，可用于在初始化最早期时做一些工作
                void starting();
                // 当environment构建完成，ApplicationContext创建之前，该方法被调用
                void environmentPrepared(ConfigurableEnvironment environment);
                // 当ApplicationContext构建完成时，该方法被调用
                void contextPrepared(ConfigurableApplicationContext context);
                // 在ApplicationContext完成加载，但没有被刷新前，该方法被调用
                void contextLoaded(ConfigurableApplicationContext context);
                // 在ApplicationContext刷新并启动后，CommandLineRunners和ApplicationRunner未被调用前，该方法被调用
                void started(ConfigurableApplicationContext context);
                // 在run()方法执行完成前该方法被调用
                void running(ConfigurableApplicationContext context);
                // 当应用运行出错时该方法被调用
                void failed(ConfigurableApplicationContext context, Throwable exception);
            }
            SpringApplicationRunListener是整个容器运行启动的监听者，它的实现类会将监听过程封装成事件，并且类中定义一个广播类
            将事件广播出去，相应的ApplicationListener会根据事件类型进行处理
 *@Param:
*@return:
*@Author: Su
*@date: 2020/9/2
*/
@SpringBootApplication
public class ConfigDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigDemoApplication.class, args);
    }

}

package com.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author : molamola
 * @Project: edu
 * @Description: 允许全局跨域的配置类
 *              协议、端口、和域名有任意一个不同就会造成跨域。
 *              同源策略是浏览器上为安全性考虑实施的非常重要的安全策略。
 *              两个页面地址中的协议、域名和端口号一致，则表示同源。
                同源策略的限制：
 *                  存储在浏览器中的数据，如localStroage、Cookie和IndexedDB不能通过脚本跨域访问
                    不能通过脚本操作不同域下的DOM
                    不能通过ajax请求不同域的数据
               @CrossOrigin  该注解标在某个类或方法上，表示该类或方法支持跨域请求
 * @date : 2019-11-29 12:32
 **/
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        // 添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        // 放行哪些原始域
        config.addAllowedOrigin("*");
        //允许跨越发送cookie
        config.setAllowCredentials(true);
        //放行哪些原始域(头部信息)
        config.addAllowedHeader("*");
        // 放行哪些原始域(请求方式)
        config.addAllowedMethod("*");

        // 添加映射路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // 返回新的CorsFilter
        return new CorsFilter(source);
    }
}

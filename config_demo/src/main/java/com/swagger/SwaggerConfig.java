package com.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: config_demo
 * @description: swagger的配置类
 * @author: Su
 * @create: 2020-08-31 08:19
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        //让swagger中每个请求方法都带上header中的Authorization字段
        ParameterBuilder builder = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        builder.name("Authorization").description("token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        parameterList.add(builder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())  //封装系统和作者信息
                .select() //得到ApiSelectorBuilder对象
                .apis(RequestHandlerSelectors.basePackage("com")) //扫描swagger的注解
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList)
                /*
                下面两个方法的作用
                     1. 提供一个全局配置token的Authorize,当登录后获取到token，然后填入该Authorize，则其余所有接口都不用输入token了
                     2. 通过pathRegex表达式来决定哪些接口的参数可以不加Authorize
                 */
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("各种config的模板系统")
                .description("config模板")
                .contact(new Contact("su","xxx","su@xx.com"))
                .version("1.0")
                .build();
    }

    private List<ApiKey> securitySchemes() {
        //设置请求头信息
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/.*"));

        return result;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }

}

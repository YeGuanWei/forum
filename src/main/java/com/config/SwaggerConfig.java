package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Yegua
 */
@Configuration
@EnableOpenApi
@EnableWebMvc
public class SwaggerConfig {

    /**
     * 默认访问路径  http://127.0.0.1:8080/swagger-ui/index.html
     */

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // .enable(true) // 开启关闭功能已经放到配置文件中
                .groupName("Forum")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.controller"))
                .paths(PathSelectors.ant("/controller/**"))
                .build();
    }

    @SuppressWarnings("all")
    public ApiInfo apiInfo() {
        return new ApiInfo(
                "论坛", // 标题
                "论坛项目", // 说明
                "v1.0",  // 版本
                "787139598@qq.com", //开发者团队的邮箱
                "YeGuanWei", // 开发者
                "Apache 2.0",  //许可证
                "http://www.apache.org/licenses/LICENSE-2.0" //许可证链接
        );
    }

}

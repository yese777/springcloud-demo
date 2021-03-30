package com.yese.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置类
 *
 * @author 张庆福
 * @date 2021/3/28
 */
// 设置dev/test环境开启，prod环境关闭
@Profile({"dev", "test"})
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean(value = "defaultApi")
    public Docket defaultApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        // 标题
                        .title("provider")
                        // 描述
                        .description("provider接口文档")
                        .termsOfServiceUrl("http://www.xx.com/")
                        .contact(new Contact("yese", "http://www.baidu.com/", "1321810135@qq.com"))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("分组1")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.yese.provider.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
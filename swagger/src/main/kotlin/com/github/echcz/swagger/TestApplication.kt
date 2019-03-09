package com.github.echcz.swagger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
class TestApplication{
    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.SWAGGER_2) // 设置使用swagger2文档类型
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.echcz.swagger.controller")) // 基础扫描包
                .paths(PathSelectors.any()) // 扫描所有路径
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Spring Boot Demo") // 标题
                .description("Spring Boot 整合 Swagger2 构建 Restful API doc") // 详情
                .termsOfServiceUrl("https://echcz.github.io/") // 服务条款
                .contact(Contact("Echcz", "https://github.com/echcz", "echcz@outlook.com")) // 联系人
                .version("0.0.1") // 版本
                .build()
    }
}

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}

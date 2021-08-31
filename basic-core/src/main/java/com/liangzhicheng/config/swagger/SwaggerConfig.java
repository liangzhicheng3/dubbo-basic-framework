package com.liangzhicheng.config.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description swagger-ui接口文档配置
 * @author liangzhicheng
 * @since 2021-08-28
 */
@EnableSwaggerBootstrapUI
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * @description 创建RestApi,并扫描包下Controller生成
     * @return Docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @description 创建Swagger页面信息
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API文档")
                .description("// 佛祖保佑 永不宕机 永无BUG 阿门 //")
                .contact(new Contact("liangzhicheng", "https://github.com/liangzhicheng3/", "yichengc3@163.com"))
                .version("1.0.0")
                .build();
    }

}

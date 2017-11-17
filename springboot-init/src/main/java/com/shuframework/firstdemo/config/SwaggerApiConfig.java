package com.shuframework.firstdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
  
/**  
* 描述：swagger2配置类 
* 
*/  
@EnableSwagger2
@Configuration
public class SwaggerApiConfig{  
      
    @Bean    
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shuframework"))
                .paths(PathSelectors.any())
                .build();    
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot-swagger-api接口")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .termsOfServiceUrl("")
//                .contact(new Contact("我本码农", "", "15851503917@163.com"))
                .version("v1.0")
                .build();
    }
}  

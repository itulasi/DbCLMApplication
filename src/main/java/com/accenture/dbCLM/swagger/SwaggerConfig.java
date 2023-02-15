package com.accenture.dbCLM.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(){
        return  new Docket(DocumentationType.SWAGGER_2).groupName("dbclm-api")
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.accenture.dbCLM"))
                        .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("DbCLM Service",
                "DbCLM Application",
                "version 1.0",
                "No Terms of Service URL",
                new Contact("Lakshmi Tulasi","Accenture.com","lakshmi.chavatapalli@accenture.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
                );

    }
}

package com.digitalfactory.irrigationsystem.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.awt.print.Pageable;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SwaggerConfiguration {

    static final String BASE_PACKAGE = "com.digitalfactory.irrigationsystem.controllers";

    @Bean
    public Docket allApis() {
        return new Docket(DocumentationType.SWAGGER_2)
            .ignoredParameterTypes(Pageable.class)
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(metadata())
            .groupName("all");
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Irrigation System API")
                .description("Service that exposes REST API to manage irrigation system for plot of land.")
                .version("1.0.0")
                .build();
    }

}

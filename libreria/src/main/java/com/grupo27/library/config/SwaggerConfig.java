package com.grupo27.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class SwaggerConfig {
/*
    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider swaggerResourcesProvider){
        return () -> {
            List<SwaggerResource> resourceList = new ArrayList<>();
            Arrays.asList("library")
                    .forEach(resourceName -> resourceList.add(loadResource(resourceName)));
            return resourceList;
        };
    }

    private SwaggerResource loadResource(String resource){
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(resource);
        swaggerResource.setSwaggerVersion("2.0");
        swaggerResource.setLocation("/resources/api/" + resource + ".yaml");

        return swaggerResource;
    }*/

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("com.grupo27.library.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
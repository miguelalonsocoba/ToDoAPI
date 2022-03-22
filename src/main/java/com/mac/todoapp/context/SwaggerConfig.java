package com.mac.todoapp.context;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mac.todoapp.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(ApiInfo());
	}

	private ApiInfo ApiInfo() {
		return new ApiInfo(
				"Todo API", 
				"The API REST of ToDo App.", 
				"v1", 
				"Terms of service",
				new Contact("MAC", "www.example.com", "mac@company.com"),
				"License of APi", "API license URL", Collections.emptyList());
	}
}

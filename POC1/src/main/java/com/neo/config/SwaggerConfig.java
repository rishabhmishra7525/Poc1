package com.neo.config;

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
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2) 
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.neo.controller"))
				.paths(PathSelectors.regex("/api.*"))
				.build()
		.apiInfo(getApiInfo());
				
	}

	@SuppressWarnings("unknown")
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"NeoSoft APP",
				"NeoSoft APP ", 
				"2.3", 
				"http://NeoSoft.com/", 
				new Contact("Mr.Rishabh Mishra","http:NeoSoft.com","rishabhmishra7525@gmail.com"), 
				"NeoSoft LICENSE",
				"http://NeoSoft.com/");
	}
}

package com.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@SuppressWarnings({ "unused", "serial" })
	private List<ResponseMessage> responseMessageForGET()
	{
		return new ArrayList<ResponseMessage>() {{
			add(new ResponseMessageBuilder()
					.code(500)
					.message("500 message")
					.responseModel(new ModelRef("Error"))
					.build());
			add(new ResponseMessageBuilder()
					.code(403)
					.message("Forbidden!")
					.build());
		}};
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.basePackage("com.app.resources"))
		          .paths(PathSelectors.any())
		          .build()
		          .useDefaultResponseMessages(false)
		          .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
		          .apiInfo(apiInfo());
		
	}
	
	@SuppressWarnings("unused")
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("REST API starstore")
	            .description("Aplicação Spring Boot usando baseando no desafio backend starstore usando mongodb")
	            .version("1.0.0")
	            .license("The MIT License (MIT)")
	            .licenseUrl("https://mit-license.org/")
	            .build();
	}
	

	
}

package com.mkyong.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
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
	      //.apis(RequestHandlerSelectors.basePackage("com.phengtola.spring.controllers.rest"))
	      .apis(RequestHandlerSelectors.basePackage("com.mkyong"))
	      .paths(PathSelectors.any())
	      //.paths(PathSelectors.ant("/v2/api/article"))
	      .build()
	      .apiInfo(apiInfo());
	}
	 
	private ApiInfo apiInfo() {
	    ApiInfo apiInfo = new ApiInfo(
	      "Spring RESTful Web Service",
	      "Rural Development Bank.",
	      "API Spring",
	      "Terms of service",
	      "Ron Rith - rithronlkh@gmail.com",
	      "License of API",
	      "https://www.rdb.com.kh");
	    return apiInfo;
	}
	
//	 private ApiInfo apiInfo2() {
//	        return new ApiInfoBuilder()
//	                .title("Spring RESTful Web Service")
//	                .description("Korea Software HRD Center")
//	                .termsOfServiceUrl("http://www.khmeracademy.org")
//	                .contact("Pheng Tola")
//	                .license("Apache License Version 2.0")
//	                .licenseUrl("http://www.khmeracademy.org")
//	                .version("2.0")
//	                .build();
//	    }
}


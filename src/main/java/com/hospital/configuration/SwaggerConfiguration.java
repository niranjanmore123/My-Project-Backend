//package com.hospital.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//
//@Configuration
//public class SwaggerConfiguration {
//	
//	private ApiInfo apiInfo() {
//		return new ApiInfo("Hospital Management System", "A Basic REST API for prividing Hospital related services", "1.0", "Terms of service", "Niranjan", "www.test.com", "niranjanmore2512@gmail.com");
//		
//	}
//	
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//	}
//
//}

package com.devsnop.cashflowkeeper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	OpenAPI customOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("Hello Swagger, OpenAPI")
						.version("v1")
						.description("Cash Flow Keeper App")
						.termsOfService("https://www.linkedin.com/in/thalyshenrique7/")
						.license(new License().name("snopdev")
								.url("https://github.com/thalyshenrique7")));
	}
}

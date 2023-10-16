package com.estore.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.estore.repository")
@ComponentScan(basePackages = "com.estore")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	} 	
	
	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**") // Allow requests for /api/**
						.allowedOrigins("http://localhost:4200") // Allow requests from your Angular app
						.allowedMethods("GET", "POST") // Specify the HTTP methods you want to allow
						.allowCredentials(true); // Allow sending cookies (if applicable)

			}
		};
	}
}

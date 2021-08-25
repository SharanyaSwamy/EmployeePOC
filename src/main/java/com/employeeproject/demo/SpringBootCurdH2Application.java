package com.employeeproject.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.employeeproject.demo")

public class SpringBootCurdH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCurdH2Application.class, args);
	}

}

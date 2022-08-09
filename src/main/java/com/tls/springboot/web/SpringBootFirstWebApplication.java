package com.tls.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tls.springboot")
public class SpringBootFirstWebApplication extends org.springframework.boot.web.servlet.support.SpringBootServletInitializer {

	public static void main(String[] args) {
		System.out.println("in main...");
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootFirstWebApplication.class);
    }
}

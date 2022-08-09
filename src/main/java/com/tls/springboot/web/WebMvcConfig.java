package com.tls.springboot.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tls.springboot.verify.LicenseCheckInterceptor;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LicenseCheckInterceptor()).addPathPatterns("/loginpost");
    }
}
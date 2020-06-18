package com.whj.springbootcode.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter {
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.
                addMapping("/v1/**"). //路由
                allowedOrigins("http://localhost:3000"). //根
                allowCredentials(true).
                allowedMethods(ORIGINS).
                maxAge(3600);
    }
}

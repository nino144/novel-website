package com.example.novel_website.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Allow all origins for development; restrict in production
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*"); // Use with caution;
    }
}
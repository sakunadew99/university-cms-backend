package com.university.course_management_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                    "http://localhost:3000",
                    "https://localhost:3000",
                    "https://university-cms-frontend.vercel.app",
                    "https://university-cms-frontend-git-main-sakuna-dewanarayanas-projects.vercel.app",
                    "https://university-cms-frontend-3i2ll9pbu-sakuna-dewanarayanas-projects.vercel.app",
                    "https://university-cms-frontend-emwa-he2arshaw.vercel.app",
                    "https://*.vercel.app",
                    "https://*.railway.app",
                    "https://*.netlify.app"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

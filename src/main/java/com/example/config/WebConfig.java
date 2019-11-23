package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * spring2.0之后，这个extends WebMvcConfigurerAdapter方法就过时了，
 * 官方推荐用implements WebMvcConfigurer
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new XLInterceptor())
                .addPathPatterns("/book/**")
                .excludePathPatterns("/welcome");

        registry.addInterceptor(new XLInterceptor2())
                .addPathPatterns("/**")
                .excludePathPatterns("/validate/**");
    }
}

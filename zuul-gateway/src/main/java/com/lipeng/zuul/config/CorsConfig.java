package com.lipeng.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig  implements WebMvcConfigurer{

    static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //来源不限
                .allowedOrigins("*")
                //方法不限
                .allowedMethods(ORIGINS)
                //配置允许的自定义请求头
//                .allowedHeaders("*")
                //配置响应的头信息,其中可以设置其他的头信息，
                // 不进行配置时， 默认可以获取到Cache-Control、Content-Language、
                // Content-Type、Expires、Last-Modified、Pragma字段
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options",
                        "token",
                        "channel")
                .allowCredentials(true).maxAge(3600);
    }
}

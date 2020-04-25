package com.lipeng.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

        //静态资源配置的方法
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //注册静态资源访问路径，以及路径指向的实际地址
            registry.addResourceHandler("/img/**")
                    .addResourceLocations("file:D:\\pic\\");
        }

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowCredentials(true)
                    .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                    .maxAge(3600);

        }
    }


package com.ptit.personal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class UploadFileConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/" + Settings.RESOURCE_PREFIX + "/**")
//                .addResourceLocations(String.format("file:%s/", Settings.UPLOAD_DIR));
    }
}
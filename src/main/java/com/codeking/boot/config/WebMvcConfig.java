package com.codeking.boot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : codeking
 * @create : 2022/12/20 20:19
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 设置静态资源映射,可以自定义
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 这个是做个示范,这个地方不用配置
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:static/front/");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:static/backend/");
        log.info("自定义静态资源映射");
    }

}

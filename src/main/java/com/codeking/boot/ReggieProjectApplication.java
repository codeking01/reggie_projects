package com.codeking.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @ServletComponentScan 的作用:
 * 在SpringBoot项目中, 在引导类/配置类上加了该注解后, 会自动扫描项目中(当前包及
 * 其子包下)的@WebServlet , @WebFilter , @WebListener 注解, 自动注册Servlet的
 * 相关组件 ;
 */
@SpringBootApplication
@ServletComponentScan
public class ReggieProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReggieProjectApplication.class, args);
    }

}

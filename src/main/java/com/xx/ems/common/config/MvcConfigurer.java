package com.xx.ems.common.config;

import com.xx.ems.common.reslover.CurrentUserHandlerMethodArgReslover;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class MvcConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        //注册@CurrentUser注解的实现类
        argumentResolvers.add(new CurrentUserHandlerMethodArgReslover());
    }
}

package com.daimabaike.biz.sys.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BizConfig implements WebMvcConfigurer {

    @Autowired
    BizHandlerInterceptor BizHandlerInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {

        System.out.println("===========BizConfig===============");
        InterceptorRegistration addInterceptor = registry.addInterceptor(BizHandlerInterceptor);
        // 拦截配置
        addInterceptor.addPathPatterns("/admin/aaa");

        // 排除配置
      //  addInterceptor.excludePathPatterns("/error");
    }

}

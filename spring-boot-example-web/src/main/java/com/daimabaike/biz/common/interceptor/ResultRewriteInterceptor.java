package com.daimabaike.biz.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ResultRewriteInterceptor implements HandlerInterceptor {

    public static final String RESULT_REWRITE = ResultRewriteInterceptor.class.getName() + "_RESULT_REWRITE";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            if (handlerMethod.getBeanType().isAnnotationPresent(ResultRewrite.class)
                    || handlerMethod.getMethod().isAnnotationPresent(ResultRewrite.class)) {
                request.setAttribute(RESULT_REWRITE, 1);
            }
        }

        return true;
    }

}

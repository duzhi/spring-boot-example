package com.daimabaike.biz.sys.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
public class BizHandlerInterceptor implements HandlerInterceptor {

    private static final String CONTENT_TYPE = "text/json;charset=UTF-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // request.get

        request.getReader();
        request.getInputStream();

        System.out.println("getRequestURI=" + request.getRequestURI());


        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }

        System.out.println("BizHandlerInterceptor 111");
        //验签
        System.out.println("BizHandlerInterceptor 222");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name + "=" + request.getParameter(name));
        }
        if (!"9527".equalsIgnoreCase(request.getParameter("sign"))) {
            response.setContentType(CONTENT_TYPE);
            response.getWriter().print("{\"code\":4001,\"msg\":\"adadsad\"}");
            return false;
        }

        return true;
    }
}

package com.daimabaike.biz.sys.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

//@Configuration
//@WebFilter(urlPatterns="/admin/bb")
//@Order(1)
public class BizBodyFilter implements Filter {

    private static final String CONTENT_TYPE = "text/json;charset=UTF-8";
    @Autowired
    BizHandlerInterceptor BizHandlerInterceptor;

    public BizBodyFilter() {
        System.out.println("BizBodyFilterBizBodyFilterBizBodyFilterBizBodyFilterBizBodyFilterBizBodyFilterBizBodyFilter");
    }


//    @Override
 //   protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest)request;

        BodyHttpServletRequestWrapper b = new BodyHttpServletRequestWrapper(httpServletRequest);
        System.out.println("BizHandlerInterceptor=" + BizHandlerInterceptor);
        System.out.println(b.getBody());

        if (b.getBody().indexOf("9527") < 0) {
            response.setContentType(CONTENT_TYPE);
            response.getWriter().print("{\"code\":4001,\"msg\":\"adasdsd11111122222\"}");
            return;
        }

    chain.doFilter(b, response);

    }

    static class BodyHttpServletRequestWrapper extends HttpServletRequestWrapper {
        private final String body;

        public BodyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            StringBuilder sber = new StringBuilder();
            String strr;

            BufferedReader br =   request.getReader();

            while ((strr = br .readLine()) != null) {
                sber.append(strr);
                sber.append(" ");
            }

            body = sber.substring(0, sber.length() - (strr==null?0:1));
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            return new SpringDServletInputStream(new ByteArrayInputStream(body.getBytes()));
        }

        @Override
        public BufferedReader getReader() throws IOException {
            return new BufferedReader(new StringReader(body));
        }

        public String getBody() {
            return this.body;
        }
    }
}

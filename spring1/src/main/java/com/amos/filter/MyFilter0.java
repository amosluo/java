package com.amos.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "filter0",urlPatterns = "/*")
public class MyFilter0 implements Filter {

    //容器启动后执行
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter0 init...");
    }

    //执行servlet前执行
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter0 doFilter...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    //程序关闭时执行
    @Override
    public void destroy() {
        System.out.println("MyFilter0 destroy...");
    }
}

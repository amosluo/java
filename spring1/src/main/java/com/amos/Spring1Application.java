package com.amos;

import com.amos.listener.MySessionListener;
import com.amos.listener.RequestListener;
import com.amos.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class Spring1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring1Application.class, args);
    }

    @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet(),"/s2");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean<MySessionListener> getServletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MySessionListener> bean = new ServletListenerRegistrationBean<>(new MySessionListener());
        bean.setOrder(1);
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean<RequestListener> getRequestListenerBean(){
        ServletListenerRegistrationBean<RequestListener> bean = new ServletListenerRegistrationBean<>(new RequestListener());
        return bean;
    }
}

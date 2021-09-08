package com.amos.viewResolver;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class MyView implements View {
    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        PrintWriter writer = httpServletResponse.getWriter();
        httpServletResponse.setContentType("text/html");
        writer.write("<h1>哈哈集团</h1>");

    }
}

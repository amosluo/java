package com.amos.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session创建");
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session销毁");
        online--;
    }
}

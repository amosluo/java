package com.proxy;

import com.proxy.inte.ICalcutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyCalcutor {
    public static ICalcutor getProxy(ICalcutor calcutor){

        ClassLoader loader = calcutor.getClass().getClassLoader();
        Class<?>[] interfaces = calcutor.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rst = method.invoke(calcutor, args);
                return  rst;

            }
        };
        Object o = Proxy.newProxyInstance(loader,interfaces,h);
        return (ICalcutor)o;
    }
}

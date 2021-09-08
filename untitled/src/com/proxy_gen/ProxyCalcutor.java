package com.proxy_gen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyCalcutor<T> {
    public T getProxy(T obj){

        ClassLoader loader = obj.getClass().getClassLoader();
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rst = method.invoke(obj, args);
                return  rst;

            }
        };
        T o = (T)Proxy.newProxyInstance(loader,interfaces,h);
        return o;
    }
}

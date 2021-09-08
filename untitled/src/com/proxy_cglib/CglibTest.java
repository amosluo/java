package com.proxy_cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Calcutor.class);
        enhancer.setCallback(new CglibProxy());

        Calcutor o = (Calcutor)enhancer.create();
        System.out.println(o.add(1,3));
    }
}

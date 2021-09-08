package com.proxy;

import com.proxy.impl.Calcutor;
import com.proxy.inte.ICalcutor;

public class ProxyTest {
    public static void main(String[] args) {
        ICalcutor calcutor = ProxyCalcutor.getProxy(new Calcutor());
        System.out.println(calcutor.add(1,2));
    }
}


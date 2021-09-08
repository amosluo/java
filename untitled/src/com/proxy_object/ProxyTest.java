package com.proxy_object;

import com.proxy_object.impl.Calcutor;
import com.proxy_object.inte.ICalcutor;

public class ProxyTest {
    public static void main(String[] args) {
        ICalcutor calcutor = (ICalcutor)ProxyCalcutor.getProxy(new Calcutor());
        System.out.println(calcutor.add(1,2));
    }
}


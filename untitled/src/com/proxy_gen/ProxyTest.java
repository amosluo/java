package com.proxy_gen;

import com.proxy_gen.impl.Calcutor;
import com.proxy_gen.inte.ICalcutor;

public class ProxyTest {
    public static void main(String[] args) {
        ICalcutor calcutor = new ProxyCalcutor<ICalcutor>().getProxy(new Calcutor());
        System.out.println(calcutor.add(1,2));
    }
}


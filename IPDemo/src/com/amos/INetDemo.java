package com.amos;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class INetDemo {
    public static void main(String[] args) {
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(localHost.getHostAddress());
        System.out.println(localHost.getHostName());

        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println(loopbackAddress);


    }
}

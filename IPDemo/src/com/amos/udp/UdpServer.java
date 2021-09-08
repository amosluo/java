package com.amos.udp;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        //服务端UPD Socket，端口要与客户端端口对应
        DatagramSocket datagramSocket = new DatagramSocket(10012);
        byte[] buff = new byte[1024];
        //用来接收传过来的数据
        DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
        //利用创建好的数据包接收数据
        datagramSocket.receive(datagramPacket);
        //打印输出信息
        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

        datagramSocket.close();
    }
}

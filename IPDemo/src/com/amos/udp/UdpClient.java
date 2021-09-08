package com.amos.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        //创建UDP通信的Socket
        DatagramSocket datagramSocket = new DatagramSocket(10011);

        //从控制台读取数据
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getByName("localhost"), 10012);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}

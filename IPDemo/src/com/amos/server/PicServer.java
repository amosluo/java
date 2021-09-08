package com.amos.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PicServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //创建服务端对象，开放端口
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器已开启监听:" + serverSocket.getLocalPort());
        //创建服务端socket（监听连接）
        Socket accept = serverSocket.accept();
        System.out.println("接收到客户端连接：" + accept.getLocalAddress() + ":" + accept.getPort());
        //获取输入流
        InputStream inputStream = accept.getInputStream();
        //创建文件输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream("down.jpg");
        int data = 0;
        int length = 0;
        //读取输入流数据并写入输出流
        while ((data = inputStream.read()) != -1) {
            fileOutputStream.write(data);
            length++;
        }
        //告诉输入流：已完成数据接收
        accept.shutdownInput();

        System.out.println("收到客户端数据，长度：" + length + "bytes");

        OutputStream responseStream = accept.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream((responseStream));
        dataOutputStream.writeUTF("服务端数据接收成功！");
        accept.shutdownOutput();
        System.out.println("发送给客户端数据:" +"服务端数据接收成功！");
        Thread.sleep(100);
        responseStream.close();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}


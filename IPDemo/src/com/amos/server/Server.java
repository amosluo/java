package com.amos.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //服务端使用ServerSocket开放本地端口
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务端已开放端口：" + serverSocket.getLocalPort());
        //服务端接收客户端的连接
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream inputStream = accept.getInputStream();
        //包装输入流
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        //读取数据
        String data = dataInputStream.readUTF();
        System.out.println(data);
        //关闭所有流和连接
        dataInputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}

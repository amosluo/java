package com.amos.client;

import java.io.*;
import java.net.Socket;

public class PicClient {
    public static void main(String[] args) throws IOException {

        //创建图片的输入流对象
        FileInputStream fileInputStream = new FileInputStream("hzy.jpg");

        //创建socket
        Socket client = new Socket("localhost",10086);
        System.out.println("创建连接： " + client.getLocalAddress() + ":" + client.getLocalPort());
        //获取输出流
        OutputStream outputStream = client.getOutputStream();
        int data = 0;
        while((data = fileInputStream.read()) !=-1){
            outputStream.write(data);
        }
        //告诉输出流，已完成数据写入
        client.shutdownOutput();

        InputStream inputStream = client.getInputStream();
        System.out.println("获取来自服务端的输入流");
        byte[] buf = new byte[1024];
        int length = inputStream.read(buf);
        client.shutdownInput();
        System.out.println("服务端响应：" +new String(buf));
        inputStream.close();
        outputStream.close();
        client.close();
        fileInputStream.close();
    }
}

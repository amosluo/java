package com.amos.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建socket对象，开启io的虚拟接口
        Socket socket = new Socket("localhost", 10086);
        //获取输出流对象，向服务端发送数据
        OutputStream outputStream = socket.getOutputStream();
        //包装输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        //传输数据
        dataOutputStream.writeUTF("hello!");
        //依次关闭流
        dataOutputStream.close();
        outputStream.close();
        socket.close();

    }
}

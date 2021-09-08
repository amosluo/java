package com.amos.server;

import com.amos.models.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(10010);

        while(true) {

            final Socket accept = server.accept();
            //获取输入
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            User user = (User) objectInputStream.readObject();

            accept.shutdownInput();
            System.out.println("用户：【" + user.getUsername() + "】请求登录");
            String loginResult = "";
            if (user.getUsername().equals("luox") && user.getPassword().equals("123456")) {
                loginResult = "登录成功！";
            } else {
                loginResult = "登录失败：用户名或密码错误！";
            }

            //返回客户端登录结果
            OutputStream outputStream = accept.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(loginResult);
            accept.shutdownOutput();
            dataOutputStream.close();
            objectInputStream.close();
            inputStream.close();
            accept.close();
        }
//        accept.close();
//        server.close();

    }
}

package com.amos.client;

import com.amos.models.User;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class LoginIn {
    public static void main(String[] args) throws IOException {

        while (true) {
            Socket client = new Socket("localhost", 10010);
            OutputStream outputStream = client.getOutputStream();
            User user = getUser();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(user);
            client.shutdownOutput();

            //获取服务端响应信息
            InputStream inputStream = client.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String res = dataInputStream.readUTF();
            System.out.println(res);
            client.shutdownInput();
            objectOutputStream.close();
            outputStream.close();
            System.out.println("isClosed : " + client.isClosed());
            System.out.println("isConnected : " + client.isConnected());
            client.close();
            if (res.indexOf("失败") < 0)
                break;
        }


    }

    private static User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        return new User(username, password);
    }
}

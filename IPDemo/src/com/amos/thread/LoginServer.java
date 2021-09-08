package com.amos.thread;

import com.amos.models.User;
import com.amos.server.Server;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer implements Runnable {

    private final Socket socket;

    public LoginServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User) objectInputStream.readObject();
            String loginResult = "";
            if (user.getUsername().equals("luox") && user.getPassword().equals("123456")) {
                loginResult = "登录成功！";
            } else {
                loginResult = "登录失败：用户名或密码错误！";
            }
            socket.shutdownInput();

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(loginResult);
            socket.shutdownOutput();

            dataOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                objectInputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10010);
        while (true){
            Socket accept = serverSocket.accept();
            LoginServer server = new LoginServer(accept);
            new Thread(server).start();

        }
    }
}

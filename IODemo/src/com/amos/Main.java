package com.amos;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        File file = new File("abc.txt");
        File outFile = new File("ccc.txt");

//        try {
//            OutputStream os = new FileOutputStream(file);
//            os.write("abc\r\n".getBytes());
//            os.write("123\r\n".getBytes());
//            os.flush();
//            os.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(outFile);
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write((buffer));
        }
        inputStream.close();
        outputStream.close();
    }
}

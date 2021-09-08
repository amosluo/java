package com.amos;

import java.io.*;

public class PictureDemo {
    public static void main(String[] args) {
        File file = new File("1.jpg");
        File outFile = new File("2.jpg");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int read = 0;
            while((read = inputStream.read(buffer))!=-1){
                outputStream.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

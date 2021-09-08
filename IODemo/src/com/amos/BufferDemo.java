package com.amos;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class BufferDemo {
    public static void main(String[] args) {
        Reader reader = null;
        try {
            reader = new FileReader("abc.txt");
            int d = 0;
            while((d = reader.read()) != -1 ){
                System.out.println((char)d);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

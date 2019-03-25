package com.learn.architect.thread.readWrite;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-14 10:42
 * @description:
 * @modified By:
 */
public class ReadData {

    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read  :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

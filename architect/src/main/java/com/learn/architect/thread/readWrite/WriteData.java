package com.learn.architect.thread.readWrite;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-14 10:42
 * @description:
 * @modified By:
 */
public class WriteData {

    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

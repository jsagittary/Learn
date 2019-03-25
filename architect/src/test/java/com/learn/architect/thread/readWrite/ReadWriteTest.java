package com.learn.architect.thread.readWrite;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-14 10:44
 * @description:
 * @modified By:
 */
public class ReadWriteTest {

    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            // inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ReadThread threadRead = new ReadThread(readData, inputStream);
            threadRead.start();

            Thread.sleep(2000);

            WriteThread threadWrite = new WriteThread(writeData, outputStream);
            threadWrite.start();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
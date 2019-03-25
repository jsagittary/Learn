package com.learn.architect.thread.readWrite;

import java.io.PipedInputStream;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-14 10:42
 * @description:
 * @modified By:
 */
public class ReadThread extends Thread {

    private ReadData read;
    private PipedInputStream input;

    public ReadThread(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override public void run() {
        read.readMethod(input);
    }

}

package com.learn.architect.thread.readWrite;

import java.io.PipedOutputStream;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-14 10:43
 * @description:
 * @modified By:
 */
public class WriteThread extends Thread {

    private WriteData write;
    private PipedOutputStream out;

    public WriteThread(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }

}

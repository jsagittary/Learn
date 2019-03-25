package com.learn.architect.thread.volatileField;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-12 14:16
 * @description:
 * @modified By:
 */
public class VolatileThread extends Thread {

    public static int count;

    synchronized private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count = i;
        }
        System.out.println("count=" + count);
    }

    @Override public void run() {
        addCount();
    }
}

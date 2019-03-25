package com.learn.architect.thread.volatileField;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-12 14:17
 * @description:
 * @modified By:
 */
public class VolatileThreadTest {

    public static void main(String[] args) {
        VolatileThread[] threads = new VolatileThread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new VolatileThread();
        }

        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
    }
}
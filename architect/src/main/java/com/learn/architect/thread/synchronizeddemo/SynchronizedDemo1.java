package com.learn.architect.thread.synchronizeddemo;

/**
 * @author: ZhouJie
 * @date: Create in 2019-02-12 14:08
 * @description:
 * @modified By:
 */
public class SynchronizedDemo1 {

    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}

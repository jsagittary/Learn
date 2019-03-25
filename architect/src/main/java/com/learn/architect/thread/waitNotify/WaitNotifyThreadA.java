package com.learn.architect.thread.waitNotify;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-12 14:32
 * @description:
 * @modified By:
 */
public class WaitNotifyThreadA extends Thread {

    private Object lock;

    public WaitNotifyThreadA(Object object) {
        super();
        this.lock = object;
    }

    @Override public void run() {
        try {
            synchronized (lock) {
                if (WaitNotify.size() != 5) {
                    System.out.println("wait begin: " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end: " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

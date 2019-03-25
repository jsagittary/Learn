package com.learn.architect.thread.waitNotify;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-12 14:32
 * @description:
 * @modified By:
 */
public class WaitNotifyThreadB extends Thread {

    private Object lock;

    public WaitNotifyThreadB(Object object) {
        super();
        this.lock = object;
    }

    @Override public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    WaitNotify.add();
                    System.out.println("添加了: " + (i + 1) + " 个元素!");
                    if (WaitNotify.size() == 5) {
                        lock.notify();
                        System.out.println("已发出通知!!!");
                    }
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

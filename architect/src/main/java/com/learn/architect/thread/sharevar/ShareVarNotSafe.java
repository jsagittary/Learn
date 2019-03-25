package com.learn.architect.thread.sharevar;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-09 16:49
 * @description: 多个线程之间共享变量线程不安全的情况
 * @modified By:
 */
public class ShareVarNotSafe extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        synchronized (this) {
            count--;
            System.out.println("由 " + ShareVarNotSafe.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {

        ShareVarNotSafe mythread = new ShareVarNotSafe();
        // 下列线程都是通过mythread对象创建的
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}

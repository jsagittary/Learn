package com.learn.architect.thread.sharevar;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-09 16:13
 * @description: 多个线程之间不共享变量线程安全的情况
 * @modified By:
 */
public class ShareVarSafe extends Thread {

    private int count = 5;

    public ShareVarSafe(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + ShareVarSafe.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {
        ShareVarSafe a = new ShareVarSafe("A");
        ShareVarSafe b = new ShareVarSafe("B");
        ShareVarSafe c = new ShareVarSafe("C");
        a.start();
        b.start();
        c.start();
    }
}

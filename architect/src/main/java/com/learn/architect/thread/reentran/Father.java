package com.learn.architect.thread.reentran;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 16:38
 * @description:
 * @modified By:
 */
public class Father {
    public int i = 10;

    synchronized public void operateIMainMethod() {
        try {
            i--;
            System.out.println("main print i=" + i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

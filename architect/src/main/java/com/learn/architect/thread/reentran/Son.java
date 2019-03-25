package com.learn.architect.thread.reentran;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 16:39
 * @description:
 * @modified By:
 */
public class Son extends Father {

    synchronized public void operateISubMethod() {
        try {
            while (i > 0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

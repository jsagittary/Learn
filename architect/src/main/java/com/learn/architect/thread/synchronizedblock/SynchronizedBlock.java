package com.learn.architect.thread.synchronizedblock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 17:07
 * @description: 长时间任务, synchronized代码块
 * @modified By:
 */
public class SynchronizedBlock {

    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName=" + Thread.currentThread().getName() + " i=" + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName=" + Thread.currentThread().getName() + " i=" + (i + 1));
            }
        }
    }

}

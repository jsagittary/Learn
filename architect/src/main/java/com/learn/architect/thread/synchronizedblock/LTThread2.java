package com.learn.architect.thread.synchronizedblock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 17:12
 * @description:
 * @modified By:
 */
public class LTThread2 extends Thread {

    private SynchronizedBlock task;

    public LTThread2(SynchronizedBlock task) {
        super();
        this.task = task;
    }

    @Override public void run() {
        super.run();
        task.doLongTimeTask();
    }
}

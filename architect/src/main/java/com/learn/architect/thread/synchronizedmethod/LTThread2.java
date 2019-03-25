package com.learn.architect.thread.synchronizedmethod;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 17:12
 * @description:
 * @modified By:
 */
public class LTThread2 extends Thread {

    private SynchronizedMethod task;

    public LTThread2(SynchronizedMethod task) {
        super();
        this.task = task;
    }

    @Override public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

package com.learn.architect.thread;

import com.learn.architect.thread.synchronizedblock.LTThread1;
import com.learn.architect.thread.synchronizedblock.LTThread2;
import com.learn.architect.thread.synchronizedblock.SynchronizedBlock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 17:08
 * @description:
 * @modified By:
 */
public class SynchronizedBlockTest {

    public static void main(String[] args) {
        SynchronizedBlock task = new SynchronizedBlock();

        LTThread1 thread1 = new LTThread1(task);
        thread1.start();

        LTThread2 thread2 = new LTThread2(task);
        thread2.start();
    }

}
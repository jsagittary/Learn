package com.learn.architect.thread;

import com.learn.architect.thread.reentran.ReentrantLock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 16:40
 * @description: 可重入锁子父继承关系
 * @modified By:
 */
public class ReentrantLockTest extends Thread {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.start();
    }

}

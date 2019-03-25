package com.learn.architect.thread.reentran;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 16:40
 * @description: 可重入锁子父继承关系
 * @modified By:
 */
public class ReentrantLock extends Thread {

    @Override public void run() {
        Son son = new Son();
        son.operateISubMethod();
    }

}

package com.learn.architect.thread.synchronizedclass;

import org.junit.Test;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-17 10:28
 * @description:
 * @modified By:
 */
public class SynchronizedStaticAndNomal {

    static SynchronizedStaticAndNomal staticAndNomal = new SynchronizedStaticAndNomal();

    @Test
    public void test() {
        new Thread(() -> staticAndNomal.staticMethod()).start();
        new Thread(() -> staticAndNomal.nomalMethod()).start();
    }

    public static synchronized void staticMethod() {
        try {
            System.out.println(System.currentTimeMillis() + ", 静态同步方法Begin :" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(System.currentTimeMillis() + ", 静态同步方法End :" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void nomalMethod() {
        try {
            System.out.println(System.currentTimeMillis() + ", 普通同步方法Begin :" + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println(System.currentTimeMillis() + ", 普通同步方法End :" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

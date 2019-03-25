package com.learn.architect.thread.threadLocal;

import java.util.Date;

/**
 * 线程变量间的隔离性
 *
 * @author: ZhouJie
 * @date: Create in 2019-01-14 16:50
 * @description:
 * @modified By:
 */
public class ThreadLocalTest3 {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在主线程中取值=" + Tools.threadLocalExt.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("在子线程中取值=" + Tools.threadLocalExt.get());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static class Tools {
        public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();
    }

    public static class ThreadLocalExt extends ThreadLocal {
        @Override protected Object initialValue() {
            return new Date().getTime();
        }
    }

}

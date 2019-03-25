package com.learn.architect.thread.threadLocal;

import java.util.Date;

/**
 * 取父线程的ThreadLocal类的变量值
 * @author: ZhouJie
 * @date: Create in 2019-01-14 17:01
 * @description:
 * @modified By:
 */
public class ThreadLocalTest4 {

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

    private static class Tools {
        public static ThreadLocal threadLocalExt = new InheritableThreadLocalExt();
    }

    private static class InheritableThreadLocalExt extends InheritableThreadLocal {
        @Override protected Object initialValue() {
            return new Date().getTime();
        }

        @Override protected Object childValue(Object parentValue) {
            return parentValue + " 我在子线程加的~!";
        }
    }

}

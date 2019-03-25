package com.learn.architect.thread.threadLocal;

/**
 * 第一次调用ThreadLocal对象的get()方法时返回的值是null
 * @author: ZhouJie
 * @date: Create in 2019-01-14 16:43
 * @description:
 * @modified By:
 */
public class ThreadLocalTest1 {

    public static ThreadLocal threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        if (threadLocal.get() == null) {
            threadLocal.set("aaa");
        }
        System.out.println(threadLocal.get());
    }
}

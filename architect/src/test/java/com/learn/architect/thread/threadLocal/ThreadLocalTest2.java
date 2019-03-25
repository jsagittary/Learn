package com.learn.architect.thread.threadLocal;

/**
 * @see ThreadLocal#initialValue() 给ThreadLocal赋默认值
 * @author: ZhouJie
 * @date: Create in 2019-01-14 16:45
 * @description:
 * @modified By:
 */
public class ThreadLocalTest2 {

    public static ThreadLocal threadLocal = new ThreadLocalExt();

    public static void main(String[] args) {
        if (threadLocal.get() == null) {
            System.out.println("从未赋值");
            threadLocal.set("赋值");
        }
        System.out.println(threadLocal.get());
    }

    private static class ThreadLocalExt extends ThreadLocal {
        @Override protected Object initialValue() {
            return "我是默认值 首次get()不为NUll";
        }
    }

}
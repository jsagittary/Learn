package com.learn.architect.thread.joinMethod;

/**
 * 在这里join方法的作用就是主线程需要等待子线程执行完成之后再结束。
 * @author: ZhouJie
 * @date: Create in 2019-01-14 11:14
 * @description:
 * @modified By:
 */
public class JoinMethodTest1 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> System.out.println("我想先执行"));
        thread.start();

        thread.join();

        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }
}

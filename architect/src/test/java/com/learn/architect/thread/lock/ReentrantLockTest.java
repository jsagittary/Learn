package com.learn.architect.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 当一个线程运行完毕后才把锁释放，其他线程才能执行，其他线程的执行顺序是不确定的
 * @author: ZhouJie
 * @date: Create in 2019-01-15 11:25
 * @description:
 * @modified By:
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        Service service = new Service();

        ThreadTest thread1 = new ThreadTest(service);
        ThreadTest thread2 = new ThreadTest(service);
        ThreadTest thread3 = new ThreadTest(service);
        ThreadTest thread4 = new ThreadTest(service);
        ThreadTest thread5 = new ThreadTest(service);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    public static class Service {

        private Lock lock = new ReentrantLock();

        public void testMethod() {
            lock.lock();
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            } finally {
                lock.unlock();
            }

        }

    }

    public static class ThreadTest extends Thread {

        private Service service;

        public ThreadTest(Service service) {
            super();
            this.service = service;
        }

        @Override public void run() {
            service.testMethod();
        }
    }
}

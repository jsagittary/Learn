package com.learn.architect.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-17 14:33
 * @description:
 * @modified By:
 */
public class FairOrNotFairLock {

    private static LockService service = new LockService(true);

    public static void main(String[] args) {
        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(() -> {
                System.out.println("★线程" + Thread.currentThread().getName() + "运行了");
                service.service();
            });
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

    }

    private static class LockService {

        private ReentrantLock lock;

        public LockService(boolean isFair) {
            super();
            lock = new ReentrantLock(isFair);
        }

        public void service() {
            lock.lock();
            try {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + "获得锁定");
            } finally {
                lock.unlock();
            }
        }
    }
}

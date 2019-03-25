package com.learn.architect.thread.lock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-17 16:31
 * @description:
 * @modified By:
 */
public class DeadLock {

    private static Object readLock = new Object();
    private static Object writeLock = new Object();
    private static DealLockService service = new DealLockService();

    public static void main(String[] args) {
        new Thread(() -> service.read()).start();
        new Thread(() -> service.write()).start();
    }

    public static class DealLockService {

        public void read() {
            synchronized (readLock) {
                System.out.println(
                        System.currentTimeMillis() + ", 线程: " + Thread.currentThread().getName() + ", 获取了readLock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (writeLock) {
                    System.out.println(System.currentTimeMillis() + ", 线程: " + Thread.currentThread().getName()
                            + ", 获取了writeLock");

                }
            }
        }

        public void write()  {
            synchronized (writeLock) {
                System.out.println(
                        System.currentTimeMillis() + ", 线程: " + Thread.currentThread().getName() + ", 获取了writeLock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (readLock) {
                    System.out.println(
                            System.currentTimeMillis() + ", 线程: " + Thread.currentThread().getName() + ", 获取了readLock");
                }
            }
        }
    }

}

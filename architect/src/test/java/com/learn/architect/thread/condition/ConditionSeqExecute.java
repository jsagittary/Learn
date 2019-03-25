package com.learn.architect.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示顺序执行
 * 默认情况下ReentranLock类使用的是非公平锁
 *
 * @author: ZhouJie
 * @date: Create in 2019-01-16 17:44
 * @description:
 * @modified By:
 */
public class ConditionSeqExecute {

    private static volatile int nextExecuteWho = 1;
    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            lock.lock();
            try {
                while (nextExecuteWho != 1) {
                    condition1.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadA :" + (i + 1));
                }
                nextExecuteWho = 2;
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread threadB = new Thread(() -> {
            lock.lock();
            try {
                while (nextExecuteWho != 2) {
                    condition2.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadB :" + (i + 1));
                }
                nextExecuteWho = 3;
                condition3.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        Thread threadC = new Thread(() -> {
            lock.lock();
            try {
                while (nextExecuteWho != 3) {
                    condition3.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("ThreadC :" + (i + 1));
                }
                nextExecuteWho = 1;
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];

        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(threadA);
            bArray[i] = new Thread(threadB);
            cArray[i] = new Thread(threadC);

            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }
    }

}

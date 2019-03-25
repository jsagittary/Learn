package com.learn.architect.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-16 17:05
 * @description:
 * @modified By:
 */
public class MoreConditionUseAwaitSignal {

    private static MoreConditionService service = new MoreConditionService();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(() -> service.awaitA());
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(() -> service.awaitB());
        threadB.setName("B");
        threadB.start();

        Thread.sleep(3000);

        service.signalAll_A();
        service.signalAll_B();
    }


    public static class MoreConditionService {

        private Lock lock = new ReentrantLock();
        public Condition conditionA = lock.newCondition();
        public Condition conditionB = lock.newCondition();

        public void awaitA() {
            lock.lock();
            try {
                System.out.println("begin awaitA时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                conditionA.await();
                System.out.println("  end awaitA时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void awaitB() {
            lock.lock();
            try {
                System.out.println("begin awaitB时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                conditionB.await();
                System.out.println("  end awaitB时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signalAll_A() {
            lock.lock();
            try {
                System.out.println("  signalAll_A时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                conditionA.signal();
            } finally {
                lock.unlock();
            }
        }

        public void signalAll_B() {
            lock.lock();
            try {
                System.out.println("  signalAll_B时间为" + System.currentTimeMillis()
                        + " ThreadName=" + Thread.currentThread().getName());
                conditionB.signal();
            } finally {
                lock.unlock();
            }
        }
    }


}

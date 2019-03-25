package com.learn.architect.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <h1>必须在{@link Condition#await()}方法调用之前调用{@link Lock#lock()}代码获得同步监视器，不然会报错。</h1>
 * @author: ZhouJie
 * @date: Create in 2019-01-16 16:26
 * @description:
 * @modified By:
 * @see ConditionService#await()  等待
 * @see ConditionService#signal() 信号
 */
public class SingleConditionUseAwaitSignal {

    private static ConditionService service = new ConditionService();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> service.await());
        thread.start();

        Thread.sleep(3000);

        service.signal();

    }

    public static class ConditionService {

        private Lock lock = new ReentrantLock();
        public Condition condition = lock.newCondition();

        public void await() {
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ", await时间");
                condition.await();
                System.out.println(System.currentTimeMillis() + ", 这是condition.await()方法之后的语句，condition.signal()方法之后我才被执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        /**
         * <p>在使用{@link Thread#wait()}/{@link Thread#notify()}实现等待通知机制的时候我们知道必须执行完{@link Thread#notify()}方法所在的synchronized代码块后才释放锁。
         * <p>在这里也差不多，必须执行完{@link Condition#signal()}所在的try语句块之后才释放锁，{@link Condition#await()}后的语句才能被执行。
         * @throws InterruptedException
         */
        public void signal() throws InterruptedException {
            lock.lock();
            try {
                System.out.println(System.currentTimeMillis() + ", signal时间");
                condition.signal();
                Thread.sleep(3000);
                System.out.println(System.currentTimeMillis() + ", 这是condition.signal()方法之后的语句");
            } finally {
                lock.unlock();
            }
        }
    }
}

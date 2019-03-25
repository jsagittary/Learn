package com.learn.architect.thread.waitNotify;

/**
 * <p>
 * <b>synchronized关键字</b>可以将任何一个Object对象作为同步对象来看待，而<b>Java为每个Object都实现了等待/通知（wait/notify）机制的相关方法</b>，
 * 它们必须用在synchronized关键字同步的Object的临界区内。通过调用{@link Object#wait()}方法可以使处于临界区内的线程进入等待状态，同时释放被同步对象的锁。
 * 而{@link Object#notify()}方法可以唤醒一个因调用wait操作而处于阻塞状态中的线程，使其进入就绪状态。
 * 被重新唤醒的线程会试图重新获得临界区的控制权也就是锁，并继续执行wait方法之后的代码。
 * 如果发出notify操作时没有处于阻塞状态中的线程，那么该命令会被忽略。<br />
 * <b>{@link Object#notify()}执行后并不会立即释放锁, 需要执行完所在的synchronized代码块才释放 </b>
 * </p>
 * @author: ZhouJie
 * @date: Create in 2019-01-12 14:36
 * @description: notify() wait()
 * @modified By:
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        try {

            Object o = new Object();

            WaitNotifyThreadA threadA = new WaitNotifyThreadA(o);
            threadA.start();

            Thread.sleep(50);

            WaitNotifyThreadB threadB = new WaitNotifyThreadB(o);
            threadB.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
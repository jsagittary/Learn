package com.learn.architect.thread.threadState;

/**
 * 线程的基本状态
 * <ul>
 * <li>{@link Thread.State#NEW}<br>
 *     新创建了一个线程对象
 *     </li>
 * <li>{@link Thread.State#RUNNABLE}<br>
 *     线程对象创建后, 其他线程(比如main线程）调用了该对象的{@link Thread#start()}方法.
 *     该状态的线程位于可运行线程池中, 等待被线程调度选中, 获取cpu的使用权
 *     </li>
 * <li>{@link Thread.State#BLOCKED}<br>
 *     运行(running)的线程在获取对象的同步锁时, 若该同步锁 被别的线程占用, 则JVM会把该线程放入锁池(lock pool)中.
 *     </li>
 * <li>{@link Thread.State#WAITING}<br>
 *     运行(running)的线程执行{@link Object#wait()}方法, JVM会把该线程放 入等待队列(waitting queue)中.
 *     </li>
 * <li>{@link Thread.State#TIMED_WAITING}<br>
 *     运行(running)的线程执行{@link Thread#sleep(long)}或{@link Thread#join(long)}方法, 或者发出了I/O请求时, JVM会把该线程置为阻塞状态.
 *     当{@link Thread#sleep(long)}状态超时join()等待线程终止或者超时、或者I/O处理完毕时, 线程重新转入可运行(runnable)状态.
 *     </li>
 * <li>{@link Thread.State#TERMINATED}<br>
 *     线程{@link Thread#run()}, main()方法执行结束, 或者因异常退出了run()方法, 则该线程结束生命周期. 死亡的线程不可再次复生.
 *     </li>
 * </ul>
 * <img src='./wait_notify.jpg' width="876" height="492" />
 * @author: ZhouJie
 * @date: Create in 2019-01-12 17:16
 * @description: 线程的基本状态
 * @modified By:
 */
public class ThreadState {
}

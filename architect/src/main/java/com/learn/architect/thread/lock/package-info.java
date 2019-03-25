/**
 * <h3>锁是用于通过多个线程控制对共享资源的访问的工具。<h3/>
 *
 * 在Lock接口出现之前，Java程序是靠synchronized关键字实现锁功能的。
 * JDK1.5之后并发包中新增了Lock接口以及相关实现类来实现锁功能。
 * <pre> {@code
 * Lock l = ...;
 * l.lock();
 * try {
 *   // access the resource protected by this lock
 * } finally {
 *   l.unlock();
 * }}</pre>
 *
 *
 * <p>因为Lock是接口所以使用时要结合它的实现类，另外在finall语句块中释放锁的目的是保证获取到锁之后，最终能够被释放。</p>
 * <h1>注意： 最好不要把获取锁的过程写在try语句块中，因为如果在获取锁时发生了异常，异常抛出的同时也会导致锁无法被释放。<h1/>
 * @author: ZhouJie
 * @date: Create in 2019-01-14 17:11
 * @description:
 * @modified By:
 */
package com.learn.architect.thread.lock;

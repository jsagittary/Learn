package com.learn.architect.thread.synchronizedclass;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 18:56
 * @description: Class锁对对象的所有实例起作用
 * @modified By:
 */
public class ClassService {

    /**
     * printA() synchronized代码块锁的ClassService类
     */
    public static void printA() {
        synchronized (ClassService.class) {
            try {
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printA");
                Thread.sleep(3000);
                System.out.println(
                        "线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * printB() 静态方法加上synchronized, 锁的也是ClassService类
     */
    synchronized public static void printB() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printB");
    }

    /**
     * printC() 实例方法加上synchronized, 锁的是ClassService的实例对象
     */
    synchronized public void printC() {
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "进入printC");
        System.out.println("线程名称为：" + Thread.currentThread().getName() + "在" + System.currentTimeMillis() + "离开printC");
    }
}

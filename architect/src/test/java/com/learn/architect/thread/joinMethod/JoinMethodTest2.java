package com.learn.architect.thread.joinMethod;

/**
 * 在这里join方法的作用就是主线程需要等待子线程执行完成之后再结束。
 * {@link Thread#sleep(long)} 和 {@link Thread#join(long)} 的区别:
 * sleep()不会释放锁, join()会释放锁;
 * @author: ZhouJie
 * @date: Create in 2019-01-14 11:14
 * @description:
 * @modified By:
 */
public class JoinMethodTest2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                System.out.println("begin Timer=" + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        thread.join(2000);// 只等2秒
        // Thread.sleep(2000);

        System.out.println("  end timer=" + System.currentTimeMillis());
        String result = "test";
        jsonToBean(result, JoinMethodTest2.class.getClass());
    }


    public static <E> E jsonToBean(String test, Class<E> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.learn.architect.thread;

import com.learn.architect.thread.synchronizedmethod.CommonUtils;
import com.learn.architect.thread.synchronizedmethod.LTThread1;
import com.learn.architect.thread.synchronizedmethod.LTThread2;
import com.learn.architect.thread.synchronizedmethod.SynchronizedMethod;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 17:08
 * @description:
 * @modified By:
 */
public class SynchronizedMethodTest {

    public static void main(String[] args) {

        SynchronizedMethod task = new SynchronizedMethod();

        LTThread1 t1 = new LTThread1(task);
        t1.start();

        LTThread2 t2 = new LTThread2(task);
        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时：" + ((endTime - beginTime) / 1000));
    }

}
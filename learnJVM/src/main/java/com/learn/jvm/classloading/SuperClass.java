package com.learn.jvm.classloading;

/**
 * @author: ZhouJie
 * @date: Create in 2018-09-27 11:15
 * @description:
 * @modified By:
 */
public class SuperClass {
    static {
        System.out.println("SuperClass Init!");
    }

    public static int value = 1;
}

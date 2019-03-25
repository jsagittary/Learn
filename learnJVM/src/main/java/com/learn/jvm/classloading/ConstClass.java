package com.learn.jvm.classloading;

/**
 * @author: ZhouJie
 * @date: Create in 2018-09-27 11:30
 * @description:
 * @modified By:
 */
public class ConstClass {

    static {
        System.out.println("ConstClass Init!");
    }

    public static final String HEELO_WOLRD = "hello world";
}

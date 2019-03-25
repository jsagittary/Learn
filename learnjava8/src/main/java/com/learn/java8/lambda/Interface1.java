package com.learn.java8.lambda;

/**
 * @author: ZhouJie
 * @date: Create in 2018-10-22 13:49
 * @description:
 * @modified By:
 */
public interface Interface1 {
    default void method1() {
        System.out.println("method1");
    }

    default void method2() {
        System.out.println("method2");

    }
}

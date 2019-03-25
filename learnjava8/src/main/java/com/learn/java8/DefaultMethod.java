package com.learn.java8;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-23 11:13
 * @description:
 * @modified By:
 */
public interface DefaultMethod {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}

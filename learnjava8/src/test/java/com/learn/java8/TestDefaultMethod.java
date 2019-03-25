package com.learn.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-23 11:15
 * @description:
 * @modified By:
 */
public class TestDefaultMethod {

    @Test
    public void test() {
        DefaultMethod defaultMethod = new DefaultMethod() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        // DefaultMethod defaultMethod = (a) -> Math.sqrt(a);
        System.out.println(defaultMethod.calculate(100));
        System.out.println(defaultMethod.sqrt(16));
    }

    @Test
    public void test2() throws Exception {
        System.out.println(Optional.ofNullable(null).isPresent());
    }

    @Test public void test3() throws Exception {
        System.out.println();
    }
}

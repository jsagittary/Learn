package com.learn.java8.lambda;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-03 3:10
 * @description:
 * @modified By:
 */
public class ReduceTest {

    @Test
    public void test1() {
        int sumAll = Stream.of(1, 2, 3, 4).reduce(0,
                (sum, element) -> sum + element);// 给一个0是用来启动，的，若给-1，结果会是9
        System.out.println(sumAll);// 10
    }

    @Test
    public void test2() throws Exception {
        int sumAll = Stream.of(1, 2, 3, 4).reduce(0,
                Integer::sum);// 给一个0是用来启动，的，若给-1，结果会是9
        System.out.println(sumAll);// 10
    }
}

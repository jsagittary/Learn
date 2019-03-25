package com.learn.architect.string;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: ZhouJie
 * @date: Create in 2018-10-31 17:22
 * @description:
 * @modified By:
 */
public class StringTest {

    @Test public void test1() {
        StringBuffer sb = new StringBuffer();
        sb.append("1");
    }

    @Test public void test2() throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        System.out.println(list.addAll(new ArrayList<>()));
    }
}

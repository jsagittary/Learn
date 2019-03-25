package com.learn.related;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-24 16:12
 * @description:
 * @modified By:
 */
public class Test {

    @org.junit.Test
    public void test() {
        Father father = new Son();
        father.say();
    }

    @org.junit.Test public void test2() throws Exception {
        List<Integer> ids = new ArrayList();
        ids.add(1);
        ids.add(1);
        ids = ids.stream().distinct().collect(Collectors.toList());
        ArrayList<Integer> src = new ArrayList<>();
        Collections.copy(ids, src);
        List<Integer> finalIds = ids;
        src.stream().filter(integer -> !finalIds.contains(src)).forEach(System.out::println);
    }

    @org.junit.Test
    public void test3() {
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(true || true);
        System.out.println(false || false);
    }
}

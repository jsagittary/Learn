package com.learn.related.list;

import org.junit.Test;

import java.util.*;

/**
 * @author: ZhouJie
 * @date: Create in 2018-07-14 14:52
 * @description:
 * @modified By:
 */
public class TestArrayList {


    @Test
    public void arrayListTest() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.stream().sorted(Comparator.comparingInt(Integer::intValue).reversed()).forEach(System.out::println);
    }

    @Test
    public void linkedListTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
    }

    @Test
    public void name() throws Exception {
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        set.add(0);
        set.add(null);
        System.out.println(set.size());
    }

    @Test
    public void test() throws Exception {
        String string = "1";
        String[] split = string.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() throws Exception {
        List<Integer> list = Arrays.asList(10, 30, 50, 80, 100, 150);
        System.out.println(list.size());
        System.out.println(list.get(5));
    }

    @Test
    public void test3() throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(0));
    }
}

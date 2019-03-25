package com.learn.architect.thread.extend;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: ZhouJie
 * @date: Create in 2019-03-20 16:19
 * @description:
 * @modified By:
 */
public class ExtendTest {
    public static void main(String[] args) {
        // List<Father> fathers = new ArrayList<>();
        // fathers.add(new Son());
        // fathers.forEach(f -> System.out.println(f instanceof Son));
        List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        list.remove(Integer.valueOf(1));
        list.forEach(i -> System.out.println(i));
    }
}

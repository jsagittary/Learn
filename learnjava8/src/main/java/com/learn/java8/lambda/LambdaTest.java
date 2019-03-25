package com.learn.java8.lambda;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-23 11:26
 * @description:
 * @modified By:
 */
public class LambdaTest {

    List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    /**
     * Java8之前的写法
     */
    @Test
    public void test() {
        names.stream().forEach(System.out::println);
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.sort(names);
        names.stream().forEach(System.out::println);
    }

    /**
     * java8Lambda表达式
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        names.stream().forEach(System.out::println);
        // lambda 表达式:
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        // 更短更易读
        Collections.sort(names, ((String a, String b) -> a.compareTo(b)));
        // 精简
        names.sort(((a, b) -> a.compareTo(b)));
        names.stream().forEach(System.out::println);
    }

    @Test public void test3() throws Exception {
        names.stream().filter(n -> true).forEach(System.out::println);
        System.out.println(false && false);
        System.out.println(false && true);
        System.out.println(true && true);
        System.out.println(true && false);
    }

    @Test public void test4() throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override public void run() {
                System.out.println("Hello Lambda!");
            }
        });
        t.run();

        new Thread(() -> System.out.println("Hello Lambda2!")).run();
    }

    @Test public void test5() throws Exception {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer val : arr) {
            if (val > 3) {
                System.out.println(val);
                break;
            }
        }
    }

    @Test public void test6() throws Exception {
        ArrayList<Object> arr = new ArrayList<>();
        System.out.println(arr.get(0));
    }
}

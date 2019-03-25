package com.learn.java8.lambda;

import com.learn.java8.entity.Student;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-03 2:54
 * @description:
 * @modified By:
 */
public class FlatMapTest {

    @Test
    public void test() {
        List<Integer> collected0 = new ArrayList<>();
        collected0.add(1);
        collected0.add(3);
        collected0.add(5);
        List<Integer> collected1 = new ArrayList<>();
        collected1.add(2);
        collected1.add(4);
        collected1 = Stream.of(collected0, collected1)
                .flatMap(num -> num.stream()).collect(Collectors.toList());
        System.out.println(collected1);// 1,3,5,2,4

    }

    @Test
    public void test2() throws Exception {
        long count = Stream.of(Arrays.asList("apple", "click"), Arrays.asList("boss", "dig", "qq", "vivo"), Arrays.asList("c#", "biezhi"))
                .flatMap(Collection::stream)
                .filter(str -> str.length() <= 2)
                .count();
        System.out.println(count);
        Stream<List<String>> listStream = Stream
                .of(Arrays.asList("apple", "click"), Arrays.asList("boss", "dig", "qq", "vivo"),
                        Arrays.asList("c#", "biezhi"));
        Stream<String> stringStream = Stream
                .of(Arrays.asList("apple", "click"), Arrays.asList("boss", "dig", "qq", "vivo"),
                        Arrays.asList("c#", "biezhi")).flatMap(Collection::stream);
    }

    @Test
    public void test3() throws Exception {
        List<Integer> collected0 = new ArrayList<>();
        collected0.add(5);
        collected0.add(7);
        collected0.add(3);
        collected0.add(2);
        collected0.add(10);
        collected0.stream().sorted((i1, i2) -> i1 - i2).forEach(System.out::println);
    }

    @Test
    public void test4() throws Exception {
        Student student1 = new Student();
        student1.setName("mkyong");
        student1.addBook("Java 8 in Action");
        student1.addBook("Spring Boot in Action");
        student1.addBook("Effective Java (2nd Edition)");
        Student student2 = new Student();
        student2.setName("zilap");
        student2.addBook("Learning Python, 5th Edition");
        student2.addBook("Effective Java (2nd Edition)");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        List<String> collect =
                list.stream()
                        .map(x -> x.getBook())      //Stream<Set<String>>
                        .flatMap(x -> x.stream())   //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());
        collect.forEach(System.out::println);

    }

    @Test
    public void test5() throws Exception {
        int[] intArray = {1, 2, 3, 4, 5, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

        intStream.forEach(x -> System.out.println(x));

    }

    @Test public void test6() throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map);
        map.entrySet().stream().sorted((en1, en2) -> en2.getValue() - en1.getValue())
                .forEach(en -> {
                    System.out.print("{" + en.getKey() + "=" + en.getValue() + "}");
                });
        System.out.println();
        Map sortMap = map.entrySet().stream().sorted((en1, en2) -> en2.getValue() - en1.getValue())
                .collect(Collectors.toMap(en -> en.getKey(), en -> en.getValue()));
        System.out.println(sortMap);
    }
}

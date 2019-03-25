package com.learn.java8.entity;

import java.util.List;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-03 3:17
 * @description:
 * @modified By:
 */
public class Person {
    private int age;
    private String gen;
    private String firstName;
    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public Person(int age, String gen, String firstName, List<Integer> list) {
        this.age = age;
        this.gen = gen;
        this.firstName = firstName;
        this.list = list;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

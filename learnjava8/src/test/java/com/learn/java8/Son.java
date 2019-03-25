package com.learn.java8;

/**
 * @author: ZhouJie
 * @date: Create in 2018-11-15 15:26
 * @description:
 * @modified By:
 */
public class Son extends Father {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void newInstance() {
        this.age = 1;
        super.newInstance();
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.newInstance();
        System.out.println(son.age);
        System.out.println(son.name);
        System.out.println(Integer.valueOf(1) == 1);
    }
}

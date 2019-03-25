package com.learn.architect.callbyval;

/**
 * @author: ZhouJie
 * @date: Create in 2018-11-20 16:09
 * @description:
 * @modified By:
 */
public class ExampleOne {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}

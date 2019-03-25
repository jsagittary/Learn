package com.learn.architect.callbyval;

/**
 * @author: ZhouJie
 * @date: Create in 2018-11-20 16:11
 * @description:
 * @modified By:
 */
public class ExampleTwo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }

    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }

}

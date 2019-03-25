package com.learn.java8;

import java.util.Arrays;

/**
 * @author: ZhouJie
 * @date: Create in 2018-09-17 15:46
 * @description:
 * @modified By:
 */
public class Solution {

    private static int[] nums = { 2, 7, 11, 15 };
    private static int target = 9;

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - 1; j++) {
                int m = nums[i] + nums[j];
                if (m == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }
}

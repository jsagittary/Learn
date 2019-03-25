package com.learn.java8;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: ZhouJie
 * @date: Create in 2018-09-17 15:46
 * @description:
 * @modified By:
 */
public class Solution1 {

    private static int[] nums1 = { 1, 3 };
    private static int[] nums2 = { 2 };
    private static String s = "a";

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int centerSize = (nums1.length + nums2.length) / 2;
        int[] newArr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, newArr, 0, nums1.length);
        System.arraycopy(nums2, 0, newArr, nums1.length, nums2.length);
        Arrays.sort(newArr);
        if (newArr.length % 2 == 0) {
            return (newArr[centerSize] + newArr[centerSize - 1]) / 2.0;
        } else {
            return newArr[centerSize];
        }
    }

    public static String longestPalindrome(String s) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        char c = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            if (c != chars[i] && map.containsKey(chars[i]) && sb.toString().length() > result.length()) {
                result = sb.toString();
                sb = new StringBuffer();
            }
            c = chars[i];
            map.put(chars[i], 1);
        }
        return result;
    }

    public static String longestPalindrome2(String s) {
        String result = "";
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String substring;
            if (map.containsKey(chars[i])) {
                Integer index = map.get(chars[i]);
                substring = s.substring(index, i + 1);
            } else {
                substring = new StringBuilder().append(chars[i]).toString();
                map.put(chars[i], i);
            }
            if (substring.length() > result.length()) {
                result = substring;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(longestPalindrome2(s));
    }
}

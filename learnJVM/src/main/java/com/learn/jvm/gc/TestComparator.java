package com.learn.jvm.gc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: ZhouJie
 * @date: Create in 2018-07-05 18:44
 * @description:
 * @modified By:
 */
public class TestComparator {

    public static void main(String[] args) {
        Map<Integer, String> map = getTreeMap();
        map.put(5, "产品线5");
        map.put(1, "产品线1");
        map.put(2, "产品线2");
        map.put(3, "产品线3");
        System.out.println(map);
    }

    @org.junit.Test
    public void test() throws Exception {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list.forEach(map -> {
            map.entrySet().forEach(en -> {
                // en.getKey()
            });
        });
    }



    private static Map<Integer, String> getTreeMap() {
        return new TreeMap<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
    }

    @org.junit.Test public void test1() throws Exception {
        List<Integer> arr = Arrays.asList(1, 2, 3);
        arr = arr.stream().filter(e -> {
            return false;
        }).collect(Collectors.toList());
        System.out.println(arr);
    }

    @org.junit.Test public void test2() throws Exception {
        String s = "1:";
        s.replaceAll("/", "");
        System.out.println(s);
    }

    @org.junit.Test public void test3() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("[ type: ").append(1).append(", id: ").append(1)
                .append(", count: ").append(1).append("]").append("\r\n");
        sb.append("[ type: ").append(2).append(", id: ").append(2)
                .append(", count: ").append(2).append("]").append("\r\n");
        System.out.println(sb);
    }
}

package com.learn.jvm.gc;

import java.util.*;

/**
 * @author: ZhouJie
 * @date: Create in 2018-07-05 18:50
 * @description:
 * @modified By:
 */
public class Test {
    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String,Object> map5 = new HashMap<String,Object>();
        map5.put("line_id", 5);
        map5.put("line_name", "产品线5");
        list.add(map5);
        Map<String,Object> map1 = new HashMap<String,Object>();
        map1.put("line_id", 1);
        map1.put("line_name", "产品线1");
        list.add(map1);
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("line_id", 2);
        map2.put("line_name", "产品线2");
        list.add(map2);
        Map<String,Object> map3 = new HashMap<String,Object>();
        map3.put("line_id", 3);
        map3.put("line_name", "产品线3");
        list.add(map3);
        //求帮忙排序
        Collections.sort(list, new MapComparatorByidAsc());
        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).get("line_id")+"====="+list.get(i).get("line_name"));
        }
    }

    static class MapComparatorByidAsc implements Comparator<Map<String, Object>> {

        @Override
        public int compare(Map<String, Object> o1, Map<String, Object> o2) {
            // TODO Auto-generated method stub

            Integer id1 = (Integer) o1.get("line_id");
            Integer id2 = (Integer) o2.get("line_id");
            // Integer id1 = Integer.valueOf(s1);
            // Integer id2 = Integer.valueOf(s2);
            if (id2 != null) {
                return id1.compareTo(id2);
            }
            return 0;

        }

    }
}

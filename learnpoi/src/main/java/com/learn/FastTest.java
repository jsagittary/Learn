package com.learn;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-05 17:25
 * @Description:
 * @Modified By:
 */
public class FastTest {

    private CopyOnWriteArrayList haveBijou = new CopyOnWriteArrayList();

    // private List<Integer> haveBijou = Arrays.asList(3, 2, 2, 2, 1, 1, 1);

    private Map<Integer, List<Integer>> needLevel = new HashMap<>();

    private Map<Integer, Integer> needExp = new HashMap<>();

    private Map<Integer, Integer> costBijou = new HashMap<>();

    private List<Integer> costBijouArr = new ArrayList<>();




    @Test
    public void fastTest() throws Exception {
        needExp.put(4, 27);
        needExp.put(3, 9);
        needExp.put(2, 3);
        needExp.put(1, 1);
        needLevel.put(4, Arrays.asList(3, 3, 3));
        needLevel.put(3, Arrays.asList(2, 2, 2));
        needLevel.put(2, Arrays.asList(1, 1, 1));
        needLevel.put(1, Arrays.asList(1));
        // haveBijou.add(3);
        // haveBijou.add(2);
        // haveBijou.add(2);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        // haveBijou.add(1);
        haveBijou.add(3);
        haveBijou.add(3);
        haveBijou.add(2);
        haveBijou.add(1);
        haveBijou.add(1);
        haveBijou.add(1);
        haveBijou.add(1);
        haveBijou.add(1);
        haveBijou.add(1);
        costBijou(4, needExp.get(4));
        System.out.println(costBijouArr);
    }

    private void costBijou(Integer wantCost, Integer needExp) {
        if (wantCost < 0) {
            return;
        }
        final List<Integer> needBijou = needLevel.get(wantCost);
        for (Integer bijou : needBijou) {
            int falg = haveBijou.indexOf(bijou);
            if (falg < 0) {
                costBijou(wantCost - 1, needExp);
            } else {
                haveBijou.remove(bijou);
                costBijouArr.add(bijou);
                needExp -= bijou;
                if (needExp == 0) {
                    return;
                }
            }
        }
    }
}

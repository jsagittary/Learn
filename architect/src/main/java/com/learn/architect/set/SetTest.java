package com.learn.architect.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: ZhouJie
 * @date: Create in 2018-10-10 18:06
 * @description:
 * @modified By:
 */
public class SetTest {

    public static void main(String[] args) {
        // Set 集合存和取的顺序不一致。
        Set hs = new HashSet();
        hs.add("世界军事");
        hs.add("兵器知识");
        hs.add("舰船知识");
        hs.add("汉和防务");
        System.out.println(hs);
        // [舰船知识, 世界军事, 兵器知识, 汉和防务]
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}

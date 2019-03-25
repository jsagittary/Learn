package com.learn.architect.thread.waitNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-12 14:29
 * @description:
 * @modified By:
 */
public class WaitNotify {

    private static List<String> list = new ArrayList();

    public static void add() {
        list.add("jsagittary");
    }

    public static int size() {
        return list.size();
    }


}

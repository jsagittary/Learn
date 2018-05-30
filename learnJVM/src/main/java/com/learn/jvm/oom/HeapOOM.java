package com.learn.jvm.oom;

import java.util.ArrayList;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author: ZhouJie
 * @date: Create in 2018-05-28 11:12
 * @description: 堆内存溢出异常测试
 * @modified By:
 */
public class HeapOOM {
    static class OOMObhect {

    }

    public static void main(String[] args) {
        ArrayList<OOMObhect> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObhect());
        }
    }
}

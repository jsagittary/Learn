package com.learn.jvm.oom;

import org.junit.Test;

import java.util.ArrayList;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author: ZhouJie
 * @date: Create in 2018-05-28 14:35
 * @description: 运行时常量池导致的内存溢出异常
 * @modified By:
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用List保持着常量池引用,避免Full GC回收常量池行为
        ArrayList<String> list = new ArrayList<>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    @Test
    public void test() {
        String s1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern() == s2);
    }
}

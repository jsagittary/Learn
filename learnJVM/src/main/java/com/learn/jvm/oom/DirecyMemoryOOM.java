package com.learn.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args:
 * @author: ZhouJie
 * @date: Create in 2018-05-28 17:01
 * @description: 使用Unsafe分配本机内存
 * @modified By:
 */
public class DirecyMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}

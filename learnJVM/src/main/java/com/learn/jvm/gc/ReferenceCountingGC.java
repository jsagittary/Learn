package com.learn.jvm.gc;

/**
 * @author: ZhouJie
 * @date: Create in 2018-05-28 19:16
 * @description: testGC()方法执行后, objA和ibjB会不会被GC呢?
 * @modified By:
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存,以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    private static void testGC() {
        ReferenceCountingGC gcA = new ReferenceCountingGC();
        ReferenceCountingGC gcB = new ReferenceCountingGC();
        gcA.instance = gcB;
        gcB.instance = gcA;

        gcA = null;
        gcB = null;

        // 假设在这行发生GC, gcA和gcB是否能被回收?
        System.gc();
    }
}

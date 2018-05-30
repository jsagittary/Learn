package com.learn.jvm.oom;

/**
 * VM Args: -Xss2M
 * @author: ZhouJie
 * @date: Create in 2018-05-28 14:14
 * @description: 创建线程导致内存溢出异常(Windows环境下可能会导致系统假死)
 * @modified By:
 */
public class JavaVMStackOOM {

    public void dontStop() {
        while (true) {

        }
    }

    public void statckLeakByThread() {
        while (true) {
            new Thread(() -> {
                dontStop();
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.statckLeakByThread();
    }
}

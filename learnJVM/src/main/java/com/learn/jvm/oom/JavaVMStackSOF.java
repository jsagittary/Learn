package com.learn.jvm.oom;

/**
 * VM Args: -Xss128k
 * @author: ZhouJie
 * @date: Create in 2018-05-28 14:07
 * @description: 虚拟机栈和本地方法栈OOM测试
 * @modified By:
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void statckLeak() {
        stackLength++;
        statckLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.statckLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}

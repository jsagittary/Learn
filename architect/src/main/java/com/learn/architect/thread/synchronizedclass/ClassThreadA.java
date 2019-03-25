package com.learn.architect.thread.synchronizedclass;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-12 16:41
 * @description:
 * @modified By:
 */
public class ClassThreadA extends Thread {

    private ClassService service;

    public ClassThreadA(ClassService service) {
        super();
        this.service = service;
    }

    @Override public void run() {
        service.printA();
    }
}

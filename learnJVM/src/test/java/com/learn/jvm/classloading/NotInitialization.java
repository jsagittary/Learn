package com.learn.jvm.classloading;

import org.junit.Test;

/**
 * @author: ZhouJie
 * @date: Create in 2018-09-27 11:17
 * @description: 被动引用不会初始化的例子
 * @modified By:
 */
public class NotInitialization {

    /**
     * 通过子类引用父类的静态字段, 不会导致子类初始化
     * @throws Exception
     */
    @Test public void staticField() throws Exception {
        System.out.println(SubClass.value);
    }

    /**
     * 通过数组定义来引用类, 不会触发此类的初始化
     * @throws Exception
     */
    @Test public void array() throws Exception {
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     * 常量在编译阶段会存入调用类的常量池中, 本质上并没有直接引用到定义常量的类,
     * 因此不会触发定义常量的类的初始化.
     * @throws Exception
     */
    @Test public void constField() throws Exception {
        System.out.println(ConstClass.HEELO_WOLRD);
    }

}
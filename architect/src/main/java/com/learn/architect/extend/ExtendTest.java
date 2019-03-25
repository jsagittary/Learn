package com.learn.architect.extend;

import org.junit.Test;

/**
 * @author: ZhouJie
 * @date: Create in 2018-10-10 15:02
 * @description:
 * @modified By:
 */
public class ExtendTest {



    class Father {

        public void say() {
            System.out.println("Father say!");
        }

    }


    public class Son extends Father {

        @Override public void say() {
            System.out.println("Son say!");
        }
    }

    @Test
    public void test1() {
        Father father = new Son();
        father.say();
    }

}

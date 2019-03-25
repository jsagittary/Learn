package com.learn.architect.thread;

import com.learn.architect.thread.publicvar.PublicVar;
import com.learn.architect.thread.publicvar.PublicVarThread;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 10:59
 * @description:
 * @modified By:
 */
public class PublicVarTest {

    public static void main(String[] args) {
        try {
            PublicVar publicVarRef = new PublicVar();
            PublicVarThread thread = new PublicVarThread(publicVarRef);
            thread.start();

            Thread.sleep(200);//打印结果受此值大小影响

            publicVarRef.getValue();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
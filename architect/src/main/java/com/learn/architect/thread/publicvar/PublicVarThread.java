package com.learn.architect.thread.publicvar;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 10:57
 * @description:
 * @modified By:
 */
public class PublicVarThread extends Thread {

    private PublicVar publicVar;

    public PublicVarThread(PublicVar publicVar) {
        super();
        this.publicVar = publicVar;
    }

    @Override public void run() {
        super.run();
        publicVar.setValue("B", "BB");
    }
}

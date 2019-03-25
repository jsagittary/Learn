package com.learn.architect.thread.publicvar;

/**
 * @author: ZhouJie
 * @date: Create in 2019-01-10 10:57
 * @description: 共享变量实例变量
 * @modified By:
 */
public class PublicVar {

    public String username = "A";
    public String password = "AA";

    synchronized public void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(5000);
            this.password = password;

            System.out.println(
                    "setValue method thread name=" + Thread.currentThread().getName() + " username=" + username
                            + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 该方法前加上synchronized关键字就同步了
    public void getValue() {
        System.out.println("getValue method thread name=" + Thread.currentThread().getName() + " username=" + username
                + " password=" + password);
    }


}

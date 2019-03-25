package com.learn.architect.thread.synchronizedclass;

/**
 * <p>静态同步方法与synchronized(class)代码块持有的锁一样, 都是Class锁 <br />
 * Class锁对对象的所有实例起作用  <br />
 * synchronized关键字加到非static静态方法上持有的是对象锁。 </p>
 * @author: ZhouJie
 * @date: Create in 2019-01-12 16:43
 * @description:
 * @modified By:
 */
public class ClassServiceTest {

    public static void main(String[] args) {
        ClassService service = new ClassService();
        ClassThreadA threadA = new ClassThreadA(service);
        threadA.setName("A");
        threadA.start();

        ClassThreadB threadB = new ClassThreadB(service);
        threadB.setName("B");
        threadB.start();

        ClassThreadC threadC = new ClassThreadC(service);
        threadC.setName("C");
        threadC.start();
    }

}
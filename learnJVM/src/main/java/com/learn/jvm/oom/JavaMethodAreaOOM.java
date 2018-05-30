package com.learn.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author: ZhouJie
 * @date: Create in 2018-05-28 15:51
 * @description: 借助CGLib使方法区出现内存溢出异常
 * @modified By:
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObhect.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, objs, proxy) -> proxy.invokeSuper(obj, objs));
            enhancer.create();
        }
    }

    static class OOMObhect {

    }

}

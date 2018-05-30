package com.learn.handler;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-05 11:17
 * @Description:
 * @Modified By:
 */
public interface UserTypeHandler<T> {
    T getResult(String convertParam);
}

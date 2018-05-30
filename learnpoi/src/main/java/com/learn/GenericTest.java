package com.learn;

import com.learn.handler.ListIntTypeHandler;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-05 11:39
 * @Description:
 * @Modified By:
 */
public class GenericTest {

    private List<List<Integer>> lists;

    @Test
    public void genericTest() throws Exception {
        // 对于继承的父类是泛型的情况
        ParameterizedType  genericSuperclass = (ParameterizedType) ListIntTypeHandler.class.getGenericInterfaces()[0];
        System.out.println(genericSuperclass);
        Type type = genericSuperclass.getActualTypeArguments()[0];
        System.out.println(type);


    }

}

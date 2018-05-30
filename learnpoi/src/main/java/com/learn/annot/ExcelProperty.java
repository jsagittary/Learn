package com.learn.annot;

import com.learn.handler.UserTypeHandler;

import java.lang.annotation.*;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 16:22
 * @Description:
 * @Modified By:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelProperty {

    /**
     * 别名对应Excel中的表头值
     * @return
     */
    String value() default "";

    /**
     * 用来解析的Handler
     * @return
     */
    Class<? extends UserTypeHandler> convertHandler();



}

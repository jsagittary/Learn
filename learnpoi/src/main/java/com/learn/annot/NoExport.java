package com.learn.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ZhouJie
 * @Date: Create in 2018-05-04 11:10
 * @Description: 自定义标签: 标注了的对象不导出导入
 * @Modified By:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoExport {

}

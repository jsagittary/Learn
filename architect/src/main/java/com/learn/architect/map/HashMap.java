package com.learn.architect.map;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author: ZhouJie
 * @date: Create in 2018-12-14 17:24
 * @description:
 * @modified By:
 */
public class HashMap<K, V> {

    /**
     * 如果对象x的类是C，如果C实现了Comparable<C>接口，那么返回C，否则返回null
     */
    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts, as;
            Type t;
            ParameterizedType p;
            if ((c = x.getClass()) == String.class) // 如果x是个字符串对象
                return c; // 返回String.class

            /**
             * 为什么如果x是个字符串就直接返回c了呢 ? 因为String  实现了 Comparable 接口，可参考如下String类的定义
             * public final class String implements java.io.Serializable, Comparable<String>, CharSequence
             */

            // 如果 c 不是字符串类，获取c直接实现的接口（如果是泛型接口则附带泛型信息）
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) { // 遍历接口数组
                    // 如果当前接口t是个泛型接口
                    // 如果该泛型接口t的原始类型p 是 Comparable 接口
                    // 如果该Comparable接口p只定义了一个泛型参数
                    // 如果这一个泛型参数的类型就是c，那么返回c
                    if (((t = ts[i]) instanceof ParameterizedType) && ((p = (ParameterizedType) t).getRawType()
                            == Comparable.class) && (as = p.getActualTypeArguments()) != null && as.length == 1
                            && as[0] == c) // type arg is c
                        return c;
                }
                // 上面for循环的目的就是为了看看x的class是否 implements  Comparable<x的class>
            }
        }
        return null; // 如果c并没有实现 Comparable<c> 那么返回空
    }

    /**
     * 如果x所属的类是kc，返回k.compareTo(x)的比较结果
     * 如果x为空，或者其所属的类不是kc，返回0
     */
    @SuppressWarnings({ "rawtypes", "unchecked" }) // for cast to Comparable
    static int compareComparables(Class<?> kc, Object k, Object x) {
        return (x == null || x.getClass() != kc ? 0 : ((Comparable) k).compareTo(x));
    }

    /**
     * 用这个方法来比较两个对象，返回值要么大于0，要么小于0，不会为0
     * 也就是说这一步一定能确定要插入的节点要么是树的左节点，要么是右节点，不然就无法继续满足二叉树结构了
     * <p>
     * 先比较两个对象的类名，类名是字符串对象，就按字符串的比较规则
     * 如果两个对象是同一个类型，那么调用本地方法为两个对象生成hashCode值，再进行比较，hashCode相等的话返回-1
     */
    static int tieBreakOrder(Object a, Object b) {
        int d;
        if (a == null || b == null || (d = a.getClass().getName().
                compareTo(b.getClass().getName())) == 0)
            d = (System.identityHashCode(a) <= System.identityHashCode(b) ? -1 : 1);
        return d;
    }

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.size());
    }

}

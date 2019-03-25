package com.learn.java8.lambda;

import com.learn.java8.entity.Person;
import com.learn.java8.factory.PersonFactory;
import org.junit.Test;

import java.util.*;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-03 3:14
 * @description:
 * @modified By:
 */
public class MapTest {

    @Test public void test1() {
        List<Person> persons = new PersonFactory().getPersons(8);//随机获取8个person实例
        ArrayList<List<Person>> lists = new ArrayList<>();
        lists.add(persons);
        IntSummaryStatistics statistics = persons.stream().flatMap(person -> person.getList().stream())
                .mapToInt(Integer::intValue).summaryStatistics();

        IntSummaryStatistics intSummaryStatistics = persons.stream().mapToInt(person -> person.getAge())
                .summaryStatistics();
        System.out.println("最大年龄：" + statistics.getMax()); //最大值
        System.out.println("最小年龄：" + statistics.getMin()); //最小值
        System.out.println("年龄总和：" + statistics.getSum()); //总计
        System.out.println("人数：" + statistics.getCount());   //个数
        System.out.println("平均年龄：" + statistics.getAverage());//平均数返回的是double类型
    }

    @Test public void test2() {
        List<Person> persons = new PersonFactory().getPersons(8);//随机获取8个person实例

        /* 就是一个省略了ToIntFunction的匿名函数接口
        ToIntFunction<Person> trans = person-> person.getAge();
        Stream.mapToInt(trans)
        */

        /* 同时也相当于是代码
        ToIntFunction<Person> trans = new ToIntFunction<Person>() {
            @Override
            public int applyAsInt(Person person) {
                return person.getAge();
            }
        };
        Stream.mapToInt(trans);*/
        IntSummaryStatistics intSummaryStatistics = persons.stream().mapToInt(person -> person.getAge())
                .summaryStatistics();
    }

    @Test public void test3() throws Exception {
        List<Person> personList = new PersonFactory().getPersons(8);//随机获取8个person实例
        List<String> names = new ArrayList<>();
        personList.stream().map(person -> {
            person.setAge(person.getAge() + 5);//年龄加5岁
            return person;
        }).filter(person -> person.getAge() < 8)//年龄小于8
                .filter(person -> person.getGen().equals("男"))//男性
                .forEach(person -> names.add(person.getFirstName()));//获取姓氏
        System.out.println(names);
    }

    @Test public void test4() throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        Object o = map.get(1);
    }
}

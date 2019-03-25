package com.learn.java8.factory;



import com.learn.java8.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: ZhouJie
 * @date: Create in 2018-08-03 3:18
 * @description:
 * @modified By:
 */
public class PersonFactory {

    private List<Person> personList = new ArrayList<Person>();

    public PersonFactory() {
        personList.add(new Person(1,"男","赵", Arrays.asList(1)));
        personList.add(new Person(2, "男", "钱", Arrays.asList(1,2)));
        personList.add(new Person(3, "男", "孙",Arrays.asList(1,2,3)));
        personList.add(new Person(4, "男", "李",Arrays.asList(2)));
        personList.add(new Person(5, "男", "周",Arrays.asList(2,3)));
        personList.add(new Person(6, "男", "吴",Arrays.asList(3)));
        personList.add(new Person(7, "男", "郑",Arrays.asList(3,4)));
        personList.add(new Person(8, "男", "王",Arrays.asList(4)));
    }

    public List<Person> getPersons(int count) {
        return personList.stream().limit(count).collect(Collectors.toList());
    }
}

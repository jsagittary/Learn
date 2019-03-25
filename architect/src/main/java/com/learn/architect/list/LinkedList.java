package com.learn.architect.list;

import org.junit.Test;

/**
 * @author: ZhouJie
 * @date: Create in 2018-12-05 14:31
 * @description:
 * @modified By:
 */
public class LinkedList<E> {

    private transient Entry<E> header = new Entry<E>(null, null, null);
    private transient int size = 0;
    private int modCount;


    /** Constructs an empty list. */
    public LinkedList() {
        header.next = header.previous = header;
    }

        private static class Entry<E> {
        E element;          //元素节点
        Entry<E> next;      //下一个元素
        Entry<E> previous;  //上一个元素

        Entry(E element, Entry<E> next, Entry<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

    private Entry<E> addBefore(E e, Entry<E> entry) {
        //利用Entry构造函数构建一个新节点 newEntry，
        Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
        //修改newEntry的前后节点的引用，确保其链表的引用关系是正确的
        newEntry.previous.next = newEntry;
        newEntry.next.previous = newEntry;
        //容量+1
        size++;
        //修改次数+1
        modCount++;
        return newEntry;
    }

    @Test
    public void test1() {
        LinkedList list = new LinkedList<Integer>();
        list.addBefore(1, header);
    }
}

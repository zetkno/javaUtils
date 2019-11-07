package com.zetkno.collection;

import java.util.LinkedList;

public class DouLinkList<E> {

    public static void main(String[] args) {
//        DouLinkList douLinkList = new DouLinkList<>();
//        douLinkList.add("第一个元素");
//        System.out.println(douLinkList.last.item);
        LinkedList list = new LinkedList();
//        list.add(1);
        System.out.println(list.getLast());
    }

    private static class Node<E> {
        private E item;
        private Node<E> prev;
        private Node<E> next;

        public Node(){}

        public Node(Node prev, E item, Node next) {
            this.prev = prev;
            this.item = item;
            this.prev = prev;
        }
    }

    private Node<E> first; //头元素
    private Node<E> last;  //尾元素
    private int size;

    public boolean add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (first == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;

        return true;
    }




}

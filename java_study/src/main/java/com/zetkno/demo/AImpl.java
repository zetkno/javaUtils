package com.zetkno.demo;

import java.io.ObjectOutputStream;

public class AImpl implements A {
    @Override
    public String say() {
        return null;
    }

    public String get() {
        return "get Say";
    }

    public void set(A a) {

    }

    public static void main(String[] args) {
        A a = new AImpl();
        a.say();
    }
}

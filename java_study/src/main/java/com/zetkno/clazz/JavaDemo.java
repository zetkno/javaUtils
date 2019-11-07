package com.zetkno.clazz;

public class JavaDemo {
    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("com.zetkno.clazz.Person");
        Object obj = cls.newInstance();
        System.out.println(obj);
    }
}

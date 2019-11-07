package com.zetkno.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Person {

    public Person() {
        System.out.println("*******Person类构造方法********");
    }
    public String toString() {
        return "我是一个人，脱离了低级趣味的好人！";
    }
}
class Person1 {
    private String name;
    private int age;

    public Person1() {

    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}

class CreateObject {

    public static void main(String[] args) throws Exception{
        fieldDo();
    }

    public static void createObj() throws Exception {
        Class cls = Person1.class;
        Object obj = cls.newInstance();
        Person1 person1 = (Person1)obj;
        person1.setAge(18);
        person1.setName("JackMa");
        System.out.println("是否是Person1: " + ( obj instanceof Person1));
        System.out.println(person1);
    }
    public static void createObj1() throws Exception{
        Class cls = Class.forName("com.zetkno.clazz.Person1");
        Object obj = cls.getDeclaredConstructor(String.class, int.class).newInstance("刘备", 24);
        System.out.println("Person对象 : " + obj);
    }

    public static void methodDo() throws Exception {
        Class cls = Person1.class;
        Object object = cls.newInstance();

        Method setNameMethod = cls.getMethod("setName", String.class);
        setNameMethod.invoke(object,"张飞");
        Method getNameMethod = cls.getMethod("getName");
        System.out.println(getNameMethod.invoke(object));
    }
    public static void fieldDo() throws Exception {
        Class cls = Class.forName("com.zetkno.clazz.Person1");
        Object obj = cls.newInstance();

        Field field1 = cls.getDeclaredField("name");
        Field field2 = cls.getDeclaredField("age");
        field1.setAccessible(true);
        field2.setAccessible(true);
        System.out.println(field1.getType().getSimpleName());
        field1.set(obj, "鲁班七号");
        field2.set(obj, 14);

    }
}



package com.zetkno;

public class ArrayDemo {
    public static void main(String[] args) {
        Person0 person0 = new Person0();
        System.out.println(person0.hashCode());
//        int[] data = new int[] {1,2,3,4,5,6,7,8,9};
//        System.out.println(data[10]);
//        System.out.println(data.length);
//        ArrayUtil.sort(data);
//        ArrayUtil.revert(data);
//        printArray(data);
//        System.out.println(ArrayUtil.sum(1,2,3));
//        System.arraycopy(源数组，源数组开始点，目标数组，目标数组开始点，拷贝长度);
//        Person0[] per = new Person0[3];
//        per[0] = new Person0("张三", 14);
//        per[1] = new Person0("小李", 19);
//        per[2] = new Person0("tongtong", 21);
//        for (Person0 person0 : per) {
//            System.out.println(person0.getInfo());
//        }
    }
    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
    }
}

class Person0 {
    private String name;
    private int age;

    public Person0() {

    }

    public Person0(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return "name: " + name + ", age: " + age;
    }
}

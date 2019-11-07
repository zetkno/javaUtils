package com.zetkno;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Message {

    public static String getConuntry() {
        return "中华人民共和国";
    }
}


class Address {
    private String conuntry;
    private String province;
    private String city;
    private String street;
    private String zipcode;

    public Address() {
    }

    public Address(String conuntry, String province, String city, String street, String zipcode) {
        this.conuntry = conuntry;
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
    public String getInfo() {
        return "国家： " + this.conuntry + "、省份：" + this.province + "、城市：" + this.city + "、街道：" + this.street + "、邮编：" + this.zipcode;
    }

    public String getConuntry() {
        return conuntry;
    }

    public void setConuntry(String conuntry) {
        this.conuntry = conuntry;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

class Employee {
    private long empno;
    private String ename;
    private double salary;
    private double rate;
    public Employee() {
    }
    public Employee(long empno, String ename, double salary, double rate) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
        this.rate = rate;
    }

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double salaryIncValue() {
        return this.salary * this.rate;
    }

    public double salaryIncResult() {
        this.salary = this.salary * (1 + this.rate);
        return this.salary;
    }

    public String getInfo() {
        return "雇员编号：" + this.empno + ", 雇员姓名：" + this.ename + ", 基本工资：" + this.salary + ", 工资增长率：" + this.rate;
    }
}
class Dog {
    private String name;
    private String color;
    private int age;



    public Dog() {
        System.out.println(this);
    }
    public Dog bark() {
        System.out.println("犬吠");
        return this;
    }

    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return "狗的名字：" + this.name + ", 狗的颜色:" + this.color + ", 狗的年龄：" + this.age;
    }
}

class User {
    private String uid;
    private String password;
    private static int count = 0;
    public User() {
        this("NOID", "morenmima");
    }

    public User(String uid) {
        this(uid, "morenmima");
    }

    public User(String uid, String password) {
        this.uid = uid;
        this.password = password;
        count++;    //个数追加
    }
    public static int getCount() {
        return count;
    }
    public String getInfo() {
        return "用户名：" + this.uid + "，密码：" + this.password;
    }
}

class Book{
    private int bid;
    private String title;
    private double price;
    private static int count = 0;

    public Book(String title, double price) {
        this.bid = count + 1;
        this.title = title;
        this.price = price;
        count++;
    }

    public String getInfo() {
        return "图书编号： " + this.bid + ",名称：" + this.title + ",价格：" + this.price;
    }

    public static int getCount() {
        return count;
    }
}


class Array {
    private int[] data;
    private int foot; //进行索引控制

    public Array(int len) {
        if (len > 0) {
            this.data = new int[len];
        } else {
            this.data = new int[1];
        }
    }

    public boolean add(int num) { //数组增加
        if (this.foot < this.data.length) {
            this.data[this.foot ++] = num;
            return true;
        }
        return false;
    }
    public int[] getData() {
        return this.data;
    }

    public void increment(int num) {
        int newData[] = new int[this.data.length + num];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }
}

class SortArray extends Array {
    public SortArray(int len) {
        super(len);
    }

    public int[] getData() {
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}

class ReverseArray extends Array {
    public ReverseArray(int len) {
        super(len);
    }
    public int[] getData() {
        int center = super.getData().length / 2;
        int head = 0;
        int tail = super.getData().length - 1;
        for (int i = 0; i < center; i++) {
            int temp = super.getData()[head];
            super.getData()[head] = super.getData()[tail];
            super.getData()[tail] = temp;
            head++;
            tail--;
        }
        return super.getData();
    }
}

public class JavaDemo {
    public static void main(String[] args) throws Exception{
//        ReverseArray array = new ReverseArray(5);
//        array.add(45);
//        array.add(30);
//        array.add(56);
//        array.add(27);
//        array.add(18);
//        int result[] = array.getData();
//        for (int temp : result)
//        System.out.print(temp + "、");

//        new Channel().connect();

//        String s = "name:张三|age:16";
//        Class<Dog> dogClass = Dog.class;
//        Object dogObj = dogClass.getDeclaredConstructor().newInstance();
//        Method method = dogClass.getDeclaredMethod("bark");
//        System.out.println(method.invoke(dogObj));


//        for (int i = 0; i < 5; i++) {
//            String s = "";
//            s = "a" + i;
//            System.out.println(s);
//        }
    }

}

class ArrayReverse {

    public void revert(int[] a) {
        int x = a.length / 2;
        int head = 0;
        int tail = a.length - 1;
        for (int i = 0; i < x; i++) {
            int temp = a[head];
            a[head] =  a[tail];
            a[tail] = temp;
            head++;
            tail--;
        }
    }
}

class Channel {
    @Deprecated
    public void connect() {
        System.out.println("Channel");
    }
    public String connection() {
        return "获取连接通道";
    }

    List list = new ArrayList();
}




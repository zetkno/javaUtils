package com.zetkno.collection;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Employee e1 = new Employee(1001, "韩久明", 7000);
        Employee e2 = new Employee(1002, "pcj", 10000);
        Employee e3 = new Employee(1003, "小李", 6000);
        Employee e4 = new Employee(1001, "婧婧", 9000);
        Map<String, Employee> map = new HashMap<>();

        map.put("1001", e1);
        map.put("1002", e2);
        map.put("1003", e3);
        System.out.println(map.size());
//        map.put("1001", e4);

        Employee emp = map.get(1001);
        System.out.println();
//        System.out.println(emp.getEname());
//        System.out.println(map);
    }
}

class Employee {
    private int id;
    private String ename;
    private double salary;

    public Employee(int id, String ename, double salary) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

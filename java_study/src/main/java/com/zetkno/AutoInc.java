package com.zetkno;

public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("i : " + i);
        System.out.println("++i : " + ++i);  //先运算再生成值
        System.out.println("i : " + i);
        System.out.println("i++ : " + i++);  //先生成值再运算
        System.out.println("i : " + i);
    }
}

package com.zetkno;

public class WhilTest {
    static boolean condition() {
        boolean result = Math.random() < 0.99;
        System.out.println(result + ", ");
        return result;
    }

    public static void main(String[] args) {
        while (condition()) {
            System.out.println("在while里");
        }
        System.out.println("出while了" );
    }
}

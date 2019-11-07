package com.zetkno.stringdemo;

public class StringDemo {
    public static void main(String[] args) {
        String s = "www.google.com";
        String ss = "www." + "google." + "com";
        System.out.println(s);
        System.out.println(ss);
        System.out.println(s == ss);
        String sss = "www.".concat("google.").concat("com");
        System.out.println(sss);
        System.out.println(sss == s);
    }

    public static boolean isNumber(String str) {
        char[] result = str.toCharArray();
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            if (result[i] < '0' || result[i] > '9') {
                return false;
            }
        }
        return true;
    }
}

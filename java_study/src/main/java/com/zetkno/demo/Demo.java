package com.zetkno.demo;

import com.sun.deploy.net.HttpResponse;

import java.lang.reflect.Array;
import java.util.*;

public class Demo {
    private static int i = 0;
    private int age = i++;
    public volatile int n = 5;


    public static void main(String[] args) {

        int a = 3, b = 5;
        System.out.println("a = "  +  a + "  b = "  + b);
        a = a + b;   //a = 8
        b = a - b;   //b = 3
        a = a - b;   //a = 5

        System.out.println("a = "  +  a + "  b = "  + b);


        int[] nums = {5,4,3,2};
        Demo.bubble(nums);

    }

    public static void bubble(int[] nums) {

        int temp = 0;
        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = 0; i < nums.length - j  - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }


    }
}

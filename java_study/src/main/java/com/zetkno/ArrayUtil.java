package com.zetkno;

public class ArrayUtil {

    public static void main(String[] args) {
        Person0 person0 = new Person0();
        System.out.println(person0.hashCode());
    }

    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
    }

    public static void revert(int[] data) {
        int head = 0;
        int tail = data.length-1;
        int center = data.length/2;
        for (int i = 0; i < center; i++) {
            int temp = data[head];
            data[head] = data[tail];
            data[tail] = temp;
            head++;
            tail--;
        }
    }

    public static int sum(int ...data) {
        int sum = 0;
        for (int temp : data) {
           sum += temp;
        }
        return  sum;
    }

}

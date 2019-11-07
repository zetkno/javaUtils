package com.zetkno.leetcode;

public class QuickSort {
    public static void main(String[] args) {

        int[] arr={20,6,3,5,8,2,1,9,4,7};
        quickSort(arr, 0, arr.length - 1);
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    public static void quickSort(int a[], int beg, int end) {
        if (beg > end) {
            return;
        }
        int base = a[beg];
        int i = beg;
        int j = end;

        while (i != j) {
            //从右边找到比基准数小的
            while (base <= a[j] && i < j) {
                j--;
            }
            //从左边找比基准数大的
            while (base >= a[i] && i < j) {
                i++;
            }
            //找到后交换两个位置的值
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
//        此时a[i]=a[j]  把a[i]给到那个起始的值
        a[beg] = a[i];
//        把基准数给a[i]/
        a[i] = base;
        quickSort(a, beg, i - 1);
        quickSort(a, j + 1, end);

    }
}
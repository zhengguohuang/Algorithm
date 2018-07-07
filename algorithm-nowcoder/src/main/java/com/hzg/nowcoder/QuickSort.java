package com.hzg.nowcoder;

/**
 * 随机快速排序
 * @author zhengguohuang
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        // 数组长度小于2无需排序
        final int len = 2;
        if (arr == null || arr.length < len) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            }
            else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            }
            else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[] {less + 1, more };
    }

    /**
     * 一维int数组中i位置的数和j位置的数互换
     * @param arr 待处理的数组
     * @param i 下标1
     * @param j 下标2
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 打印数组
     * @param arr 需要被打印的数组
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i == 0)? arr[i] : "\t" + arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 8, 1};
        quickSort(arr, 0, 4);
        printArray(arr);
    }
}

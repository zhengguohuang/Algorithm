package com.hzg.nowcoder;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        if (L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);// (L + R) / 2
        sortProcess(arr, L, mid);
        sortProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];// 写入辅助数组，移位
        }
        // 两个必有且仅有一个越界
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        // 拷贝数组
//        for (int i1 = 0; i1 < help.length; i1++) {
//            arr[L + i1] = help[i1];
//        }
        System.arraycopy(help,0,arr,L,help.length);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 8};
        mergeSort(arr);
        System.out.println("over");
    }
}

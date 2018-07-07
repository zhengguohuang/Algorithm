package com.hzg.nowcoder;

public class Recursion {

    private static int getMax(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }
        int mid = (L + R) / 2;
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}

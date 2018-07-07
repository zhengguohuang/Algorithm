package com.hzg.nowcoder;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for(int end = arr.length - 1; end > 0; end--){
            for (int i = 0; i < end; i++){
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    /**
     * 交换arr数组的i和j(封装为工具类)
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 绝对正确的方法(考虑封装到接口中，自己写的类实现这个接口logarithm)
     * 不用管时间复杂度
     * 好实现的方法
     * @param arr
     */
    public static void rightMethod(int [] arr){
        Arrays.sort(arr);
    }

    // 使用对数器

    /**
     * 生成长度和值都是随机的数组
     * @param size 返回的数组长度小于对于size
     * @param value
     * @return 生成的随机数组
     */
    public static int[] generateRandomArray(int size, int value){

        // Math.random() -> double [0, 1)
        // (int) ((size + 1) * Math.random()) -> [0, size]整数
        // size = 6, size + 1 = 7;
        // Math.random() -> [0, 1) * 7 -> [0, 7) double
        // double -> int [0, 6]

        // 生成长度随机的数组
        int[] arr = new int [(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++){
            // 两个随机数减一下
            arr[i] = (int) ((int) ((value + 1) * Math.random()) - value * Math.random());
        }
        return arr;
    }

    /**
     * 拷贝数组(可封装成工具类)
     */
    public static int[] copyArray(int [] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 比较两个数组是否相同(可封装成工具类)
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2){
        // 1.一个为空一个不为空
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        // 2.两个都为空
        if (arr1 == null && arr2 == null){
            return true;
        }
        // 3.长度不相等
        if (arr1.length != arr2.length){
            return false;
        }
        // 4.遍历比较
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean successed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(size, value);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            bubbleSort(arr1);
            rightMethod(arr2);
            if(!isEqual(arr1, arr2)){
                successed = false;
                printArray(arr3);
                break;
            }
        }
        System.out.println(successed ? "Nice!" : "fuck!");

        int[] arr = generateRandomArray(size, value);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    /**
     * 打印数组(可封装成工具类)
     * @param arr 需要被打印的数组
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i == 0)? arr[i] : "\t" + arr[i]);
        }
        System.out.println();
    }
}

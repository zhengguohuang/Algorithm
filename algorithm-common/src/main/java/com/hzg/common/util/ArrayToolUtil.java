package com.hzg.common.util;

/**
 * 工具类
 * @author zhengguohuang
 */
public class ArrayToolUtil {

    /**
     * 交换数组中的元素
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 打印数组
     * @param arr 需要被打印的数组
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print((i == 0)? arr[i] : "\t" + arr[i]);
        }
        System.out.println();
    }

    /**
     * 比较两个数组是否相同
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 两个数组相同返回true
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

    /**
     * 拷贝数组
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
}

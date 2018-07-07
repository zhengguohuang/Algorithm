//package com.hzg.common.logarithm.impl;
//
//import com.hzg.common.logarithm.Logarithm;
//
//import java.util.Arrays;
//
//public class ArraryLogarithm implements Logarithm<int[], int[]> {
//    public void rightMethod(int[] arr) {
//        Arrays.sort(arr);
//    }
//
//    /**
//     * 考虑使用范围如数据范围为0-10000 start0 end 10000, 数据类型为int
//     * @param size 返回的数组长度小于对于size
//     * @param value
//     * @return
//     */
//    public int[] generateRandom(int size, int value) {
//        int[] arr = new int [(int) ((size + 1) * Math.random())];
//        for (int i = 0; i < arr.length; i++){
//            arr[i] = (int) ((int) ((value + 1) * Math.random()) - value * Math.random());
//        }
//        return arr;
//    }
//
//    public int[] copy(int[] arr) {
//        if (arr == null){
//            return null;
//        }
//        int[] res = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }
//
//    public boolean isEqual(int[] arr1, int[] arr2) {
//        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
//            return false;
//        }
//        if (arr1 == null && arr2 == null){
//            return true;
//        }
//        if (arr1.length != arr2.length){
//            return false;
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] != arr2[i]){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void print(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print((i == 0)? arr[i] : "\t" + arr[i]);
//        }
//        System.out.println();
//    }
//
//    /**
//     * 用来测试方法是否正确，应该可以输入测试测试，测试数据规模，测试数据类型
//     *
//     */
//    public void judge() {
//        int testTime = 500000;
//        int size = 10;
//        int value = 100;
//        boolean successed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr1 = generateRandom(size, value);
//            int[] arr2 = copy(arr1);
//            int[] arr3 = copy(arr1);
//            // 考虑使用反射调用本类的solution方法
//            //bubbleSort(arr1);
//            rightMethod(arr2);
//            if(!isEqual(arr1, arr2)){
//                successed = false;
//                print(arr3);
//                break;
//            }
//        }
//        System.out.println(successed ? "Nice!" : "fuck!");
//    }
//}

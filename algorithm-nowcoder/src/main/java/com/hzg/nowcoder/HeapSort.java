package com.hzg.nowcoder;

import com.hzg.common.util.ArrayToolUtil;
import java.util.Arrays;

/**
 * 堆排序
 * 堆当前元素的下标为i, 则：
 * 父节点的下标为：father = (i - 1) / 2
 * 左孩子的下标为：left = 2*i + 1
 * 右孩子的的下标为： right = left + 1
 *
 * @author zhengguohuang
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2 ) {
            return;
        }
        // 1.先建一个大根堆，时间复杂度log1 + log2 + log3 + ... + logN ~ O(logN)
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        // 2.第一次交换最大值（根顶）和最后一个元素
        ArrayToolUtil.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            // 重新调整堆，使之成为大根堆，（把换到第一个位置的元素下沉）
            heapify(arr, 0, heapSize);
            // 交换最大值（根顶）和最后一个元素
            ArrayToolUtil.swap(arr, 0, --heapSize);

        }

    }

    /**
     * 将堆的堆首元素下沉调整，使之成为大根堆
     * @param arr 存储堆的数据结构：数组
     * @param index 待下沉的元素在数组的位置
     * @param heapSize 堆的大小
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        // 非叶子节点循环就要继续下去
        while (left < heapSize) {
            // 求两个子节点的最大值所在的下标
            // 只有当右孩子存在且右孩子大于左孩子时最大值才为右孩子
            // 其余情况的最大值皆为左孩子
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            // 2.子节点中的最大值和当前节点比较，求最大
            largest = arr[largest] > arr[index] ? largest : index;
            // 若最大值就是index说明不用再继续比了，堆已经调整好了
            if (largest == index) {
                break;
            }
            // 走到此步潜台词lagest来自子节点
            // 交换index位置的值和largest位置的值
            ArrayToolUtil.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    /**
     * 插入一个元素到一个已经排好的大根堆中，每一次的时间复杂度O(log index)
     * @param arr 一个存储大根堆的数组
     * @param index 待插入大根堆的元素下标
     */
    private static void heapInsert(int[] arr, int index) {
        // 当前位置的元素大于父节点的元素值时循环执行
        while (arr[index] > arr[(index - 1) / 2]) {
            // 交换当前位置和父节点
            ArrayToolUtil.swap(arr, index, (index - 1) / 2);
            // 当前位置换为之前位置的父节点
            index = (index - 1) / 2;
        }
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

    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 5, 6};
        heapSort(arr);
        ArrayToolUtil.printArray(arr);

        // 测试次数
        int testTime = 500000;
        // 测试数组大小
        int size = 10;
        // 用哪个值为基础随机
        int value = 100;
        boolean successed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayToolUtil.generateRandomArray(size, value);
            int[] arr2 = ArrayToolUtil.copyArray(arr1);
            int[] arr3 = ArrayToolUtil.copyArray(arr1);
            heapSort(arr1);
            rightMethod(arr2);
            if(!ArrayToolUtil.isEqual(arr1, arr2)){
                successed = false;
                ArrayToolUtil.printArray(arr3);
                break;
            }
        }
        System.out.println(successed ? "Nice!" : "fuck!");
    }
}

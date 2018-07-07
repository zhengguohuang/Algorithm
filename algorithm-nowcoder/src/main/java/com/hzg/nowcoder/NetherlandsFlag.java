package com.hzg.nowcoder;

/**
 * 荷兰国旗问题
 * @author zhengguohuang
 */
public class NetherlandsFlag {

    /**
     * 对arr的l到r位置进行操作
     * @param arr 待处理的数组
     * @param l 待处理数组的开始位置
     * @param r 待处理数组的结束位置
     * @param num 与num进行比较
     * @return 等于num的两个边界
     */
    public static int[] partition(int[] arr, int l, int r, int num){
        // 小于num的位置
        int less = l - 1;
        // 大于num的位置
        int more = r + 1;
        // 当前位置
        int cur = l;
        while (cur < more) {
            // 当前位置的数小于num
            if (arr[cur] < num) {
                // arr[cur] 和小于num的边界的下一个位置的数进行交换，cur下移，less边界扩大
                swap(arr, ++less, cur++);
            }
            // 当前位置的数大于num
            else if (arr[cur] > num) {
                // arr[cur]和大于num的边界的上一个位置的数进行交换，cur不移动，more边界扩大
                swap(arr, cur ,--more);
            }
            // 当前位置的数等于num
            else {
                // cur下移
                cur++;
            }
        }

        return new int[]{less + 1, more - 1};
    }

    /**
     * 一维int数组中i位置的数和j位置的数互换
     * @param arr 待处理的数组
     * @param i 下标1
     * @param j 下标2
     */
    private static void swap(int[] arr, int i, int j) {
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

//    /**
//     * for test
//     * @param args 命令行参数
//     */
//    public static void main(String[] args) {
//        int[] arr = {1, 5, 4, 7, 5};
//        int num = 5;
//        int[] partition = partition(arr, 0, arr.length - 1, num);
//        System.out.println("over");
//    }
}

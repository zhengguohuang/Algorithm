package com.hzg.nowcoder;

/**
 * 给定一个数组，求如果排序之后，相邻两个数的最大差值，要求给定时间复杂度O(N)且要求不能用非基于比较的排序
 * @author zhengguohuang
 */
public class MaxGap {

    public static int maxGap(int[] nums){
        int invalidLen = 2;
        if (nums == null || nums.length < invalidLen){
            return 0;
        }
        // 寻找最大值和最小值
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) {
            return 0;
        }
        // 维持三个数组
        // 是否有数字进对应的桶
        boolean[] hasNum = new boolean[len + 1];
        // 桶中的最大值
        int[] maxs = new int[len + 1];
        // 桶中的最小值
        int[] mins = new int[len + 1];
        // 桶id
        int bid = 0;
        // 遍历更新三个状态数组
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(mins[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        // 获得相邻有数桶的最大差值
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++){
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    private static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}

package com.hzg.nowcoder;

/**
 * 排好序的矩阵，O(M + N)的查找
 * @author zhengguohuang
 */
public class SortMatrix {

    public static boolean find(int[][] matrix, int k) {
        int curR = 0;
        int curC = matrix[0].length - 1;

        while (curC >= 0 && curR < matrix.length) {
            if (matrix[curR][curC] > k) {
                curC --;
            } else if (matrix[curR][curC] < k) {
                curR++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                { 0, 1, 2, 3, 4, 5, 6 },
                { 10, 12, 13, 15, 16, 17, 18 },
                { 23, 24, 25, 26, 27, 28, 29 },
                { 44, 45, 46, 47, 48, 49, 50 },
                { 65, 66, 67, 68, 69, 70, 71 },
                { 96, 97, 98, 99, 100, 111, 122 },
                { 166, 176, 186, 187, 190, 195, 200 },
                { 233, 243, 321, 341, 356, 370, 380 }
        };
        int k = 52;
        System.out.println(find(matrix, k));
    }
}

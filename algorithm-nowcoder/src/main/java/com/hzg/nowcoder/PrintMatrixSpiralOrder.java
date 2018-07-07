package com.hzg.nowcoder;

/**
 * 转圈打印矩阵
 * 整体思想
 * @author zhengguohuang
 */
public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tC < dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        // 1.同一行
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        }
        // 2.同一列
        else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
        }
        // 3.正常的矩阵
        else {
            // 1.打印上边框
            for (int i = tC; i < dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
            // 2.打印右边框
            for (int i = tR; i < dR; i++) {
                System.out.print(m[i][dC] + " ");
            }
            // 3.打印下边框
            for (int i = dC; i > tC; i--) {
                System.out.print(m[dR][i] + " ");
            }
            // 4.打印左边框
            for (int i = dR; i > tR; i--) {
                System.out.print(m[i][tC] + " ");
            }
//            int curC = tC;
//            int curR = tR;
//            while (curC != dC) {
//                System.out.print(m[tR][curC] + " ");
//                curC++;
//            }
//            while (curR != dR) {
//                System.out.print(m[curR][dC] + " ");
//                curR++;
//            }
//            while (curC != tC) {
//                System.out.print(m[dR][curC] + " ");
//                curC--;
//            }
//            while (curR != tR) {
//                System.out.print(m[curR][tC] + " ");
//                curR--;
//            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }
}

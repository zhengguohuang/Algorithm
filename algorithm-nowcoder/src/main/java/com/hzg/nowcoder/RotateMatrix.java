package com.hzg.nowcoder;

/**
 * 旋转正方形
 * @author zhengguohuang
 */
public class RotateMatrix {
    public static void rotate(int[][] matrix) {
        // 左上角的点
        int tR = 0;
        int tC = 0;
        // 右下角的点
        int dR = matrix.length -1;
        int dC = matrix[0].length - 1;
        //
        while (tC < dC) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}

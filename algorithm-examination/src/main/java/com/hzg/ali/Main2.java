package com.hzg.ali;

import java.util.Scanner;

/**
 * 项目排期。

 一个软件项目包括n个事项，总共有m个人力（n>m）。每个事项只能由一个人完成，
 但一个人可以负责多个事项。每个事项有一个预估工作量值w，
 每个人针对该事项有一个效率值v（代表每天能完成该事项的工作量），
 w/v就是该人完成该事项所需的时间（天），如果w/v为小数则向上round为整数，
 比如11.3天应round为12天。由于知识背景等原因，每个人对每个事项的v值各不相同。

 现给定项目的事项列表及每个事项的预估工作量，以及每个人对每个事项的效率值v。
 通过进行合理任务分配，求完成项目所需的最小时间（天数）。
 */
public class Main2 {
    private static final int MMAX = 20;
    private static final int NMAX = 50000;
    private static final int INFTY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, m;
        int[] C= new int[20 + 1];
        int[] T = new int[NMAX + 1];
        n = s.nextInt();
        m = s.nextInt();

        for (int i = 1; i <= m; i++){
            C[i] = s.nextInt();
        }
        for (int i = 0; i <= NMAX; i++){
            T[i] = INFTY;
        }
        T[0] = 0;
        for (int i = 1; i <= m; i++){
            for (int j = 0; j + C[i] <= n; j++){
                T[j + C[i]] = Math.min(T[j + C[i]], T[j] + 1);
            }
        }
        System.out.println(T[n]);
    }
}





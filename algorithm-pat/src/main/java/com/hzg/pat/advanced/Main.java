package com.hzg.pat.advanced;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a , b;
        a = s.nextInt();
        b = s.nextInt();
        int c = a+ b;
        String result = c+"";
        for (int i = result.length(); i <= 0; i--){
            System.out.print(result.charAt(i));
        }
    }
}

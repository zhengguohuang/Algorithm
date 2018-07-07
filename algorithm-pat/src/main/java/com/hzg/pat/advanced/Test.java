package com.hzg.pat.advanced;

public class Test {
    public static void main(String[] args) {
        System.out.println(solve(100));
    }

    private static int solve(int left) {
        if(left < 3){
            return left;
        }

        return left + solve(left/3+left%3) -left%3 ;
    }
}

package com.hzg.common.test;

import com.hzg.common.logarithm.Logarithm;
import org.junit.Test;

public class MyAlgorithm implements Logarithm<Integer, Integer> {
    public static Integer myAlgorithm(Integer i){
        return i*2;
    }

    public Integer rightMethod(Integer i) {
        return i + i;
    }

    public Integer generateRandom(int size, int value) {
        return (int) ((value + 1) * Math.random());
    }

    public Integer copy(Integer i) {
        return new Integer(i);
    }

    public boolean isEqual(Integer o1, Integer o2) {
        return o1.equals(o2);
    }

    public void print(Integer i) {
        System.out.println(i);
    }

    @Test
    public void judge() {
        int testTime = 50000;
        int size = 10;
        int value = 10000;
        boolean successed = true;
        int failCount = 0;
        for (int i = 0; i < testTime; i++) {
            int i1 = generateRandom(size, value);
            int i2 = copy(i1);
            int i3 = copy(i1);
            int r1 = myAlgorithm(i1);
            int r2 = rightMethod(i2);
            if(!isEqual(r1, r2)){
                failCount++;
                successed = false;
                System.out.println(i+" 未通过测试的case:");
                print(i3);
                System.out.println("myAlgorithm结果为:" + r1);
                System.out.println("rightMethod结果为:" + r2);
                System.out.println();
                continue;
            }
        }
        System.out.println("通过率为：" + ((double)(testTime - failCount)/testTime));
        System.out.println(successed ? "Nice!" : "fuck!");
    }

}

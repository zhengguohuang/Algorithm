package com.hzg.nowcoder;

/**
 * 数组实现栈
 * @author zhengguohuang
 */
public class ArrayStack {
    private Integer[] arr;
    private Integer index;

    public ArrayStack(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init index is less than 0");
        }
        arr = new Integer[initSize];
        index = 0;
    }

    public Integer peek() {
        if (index == 0) {
            return null;
        }
        return arr[index - 1];
    }

    public void push(int obj) {
        if (index == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }
        arr[index++] = obj;
    }

    public Integer pop() {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--index];
    }
}

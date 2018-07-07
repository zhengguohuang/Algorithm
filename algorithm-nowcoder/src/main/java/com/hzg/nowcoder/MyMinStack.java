package com.hzg.nowcoder;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上
 * 再实现返回栈中最小元素的操作
 * @author zhengguohuang
 */
public class MyMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyMinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum < this.getMin()) {
            this.stackMin.push(newNum);
        } else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
}

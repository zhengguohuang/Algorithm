package com.hzg.nowcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 栈和队列的转换
 * @author zhengguohuang
 */
public class StackAndQueueConvert {

    /**
     * 用两个栈实现一个队列
     */
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
            dao();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            dao();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty");
            }
            dao();
            return stackPop.peek();
        }

        /**
         * 将stackPush栈中的数据倒到stackPop栈中
         */
        private void dao() {
            if (!stackPop.isEmpty()) {
                return;
            }
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }

    }

    /**
     * use two queue implement a stack
     */
    public static class TwoQueueStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int pushInt) {
            data.add(pushInt);
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }
    }

}

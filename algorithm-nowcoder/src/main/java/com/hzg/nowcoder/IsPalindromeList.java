package com.hzg.nowcoder;

import java.util.Stack;

/**
 * 是否为回文链表
 * @author zhengguohuang
 */
public class IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node (int data) {
            this.value = data;
        }
    }

    /**
     * 需要n的额外空间
     * @param head 链表的头结点
     * @return
     */
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        // 将节点push入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        // 出栈逐一比对
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }


    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }

    /**
     * 额外空间复杂度O(1)
     * @param head 头节点
     * @return
     */
    private static boolean isPalindrome3(Node head) {
        // 链表为空或者只有一个元素
        if (head == null || head.next == null) {
            return true;
        }
        // 1.寻找中间的节点
        // 慢指针
        Node n1 = head;
        // 快指针
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            // 慢指针走一步，快指针走两步
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 2.反转链表后半部分
        // 右半部分的第一个节点
        n2 = n1.next;
        // 中间节点的下一个节点置空
        n1.next = null;
        // n3用于保留下一个节点
        Node n3 = null;
        // right part convert
        while (n2 != null) {
            // n3->save next node
            n3 = n2.next;
            // next of right node convert
            n2.next = n1;
            // n1 move
            n1 = n2;
            // n2 move
            n2 = n3;
        }
        // 3.比对是否回文
        // n3 -> save last node
        n3 = n1;
        // n2 -> save first node
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            // left to mid
            n1 = n1.next;
            // right to mid
            n2 = n2.next;
        }

        // 4.将链表反转回原来的结构
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }

    /**
     * 使用n/2的额外空间
     * @param head 链表的头结点
     * @return
     */
    private static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 若节点个数为偶数，中点打到正中间的后一个
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        // 将右半部分放入栈
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        // 与链表的前半部分比对
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}

package com.hzg.nowcoder;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 * @author zhengguohuang
 */
public class CopyListWithRandom {
    /**
     * 含有随机节点的链表的节点
     * @author zhengguohuang
     */
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 通过map实现复制随机含有节点的链表1<br>
     * 时间复杂度:O(N)<br>
     * 空间复杂度:O(N)<br>
     * @param head 待复制节点的头指针
     * @return 复制完成后的头节点
     */
    public static Node copyListWithRand1(Node head) {
        HashMap<Node, Node> map = new HashMap<>(16);
        Node cur = head;
        // 将原链表及原链表的复制放入map
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        // 设置map的V的两个指针指向正确的副本中的位置
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * 通过map实现复制随机含有节点的链表2<br>
     * 时间复杂度:O(N)<br>
     * 空间复杂度:O(1)<br>
     * @param head 待复制节点的头指针
     * @return 复制完成后的头节点
     */
    public static Node copyListWithRand2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        // 用来保存复制后的当前节点的下一个节点
        Node next = null;
        // 复制节点和链接每一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        // curCopy为当前节点的拷贝节点
        Node curCopy = null;
        // set copy node rand
        while (cur != null) {
            // next节点为原节点的原本的next节点
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        // split
        while (cur != null) {
            curCopy = cur.next;
            next = cur.next.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    /**
     * 打印
     * @param head
     */
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order:");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);

        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);

        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("===================================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        // 1 -> 6
        head.rand = head.next.next.next.next.next;
        // 2 -> 6
        head.next.rand = head.next.next.next.next.next;
        // 3 -> 5
        head.next.next.rand = head.next.next.next.next;
        // 4 -> 3
        head.next.next.next.rand = head.next.next;
        // 5 -> null
        head.next.next.next.next.rand = null;
        // 6 -> 4
        head.next.next.next.next.next.rand = head.next.next.next;

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("===================================");
    }

}

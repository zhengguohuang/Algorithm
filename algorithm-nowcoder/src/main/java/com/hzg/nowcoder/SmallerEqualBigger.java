package com.hzg.nowcoder;

/**
 * 单向链表化成左边小中间相等两边大的形式
 * @author zhengguohuang
 */
public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 通过数组来存储链表
     * @param nodeArr 存储链表的数组
     * @param pivot 与pivot做比较
     */
    public static void arrPartition(Node[] nodeArr, int pivot) {
        // 小于区域
        int small = -1;
        // 大于区域
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }

    private static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        //head1 = listPartition1(head1, 5);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);
    }


    private static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        // 1.得到节点数组的长度
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        // 2.创建链表的节点数组，并将节点放到数组中
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        // 3.处理节点数组，小的放左边，相等放中间，大的放右边
        arrPartition(nodeArr, pivot);
        // 4.重构链表
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    /**
     * 额外空间复杂度O(1)
     * @param head 指向单链表的头节点的指针
     * @param pivot 与pivot比较
     * @return 处理后的单链表的头节点
     */
    private static Node listPartition2(Node head, int pivot) {
        /**
         * sH:small head
         * sT:small tail
         * eH:equal head
         * eT:equal tail
         * bH:big head
         * bT:big tail
         */
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        // save next node
        Node next = null;
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    /**
     * 打印链表
     * @param head 链表的头节点
     */
    private static void printLinkedList(Node head) {
        System.out.print("Linked list:");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}

package chapter06.exercise;

import java.util.HashMap;

public class Exercise04 {
    public static void main(String[] args) {
            Node head = null;
            Node res1 = null;
            Node res2 = null;
            printRandLinkedList(head);
            res1 = copyLinkedList1(head);
            printRandLinkedList(res1);
            res2 = copyLinkedList2(head);
            printRandLinkedList(res2);
            printRandLinkedList(head);
            System.out.println("=========================");

            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);
            head.next.next.next.next = new Node(5);
            head.next.next.next.next.next = new Node(6);

            head.rand = head.next.next.next.next.next; // 1 -> 6
            head.next.rand = head.next.next.next.next.next; // 2 -> 6
            head.next.next.rand = head.next.next.next.next; // 3 -> 5
            head.next.next.next.rand = head.next.next; // 4 -> 3
            head.next.next.next.next.rand = null; // 5 -> null
            head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

            System.out.println("原始链表：");
            printRandLinkedList(head);
            System.out.println("=========================");
            res1 = copyLinkedList1(head);
            System.out.println("方法一的拷贝链表：");
            printRandLinkedList(res1);
            System.out.println("=========================");
            res2 = copyLinkedList2(head);
            System.out.println("方法二的拷贝链表：");
            printRandLinkedList(res2);
            System.out.println("=========================");
            System.out.println("经历方法二拷贝之后的原始链表：");
            printRandLinkedList(head);
            System.out.println("=========================");

        }

    public static class Node {
        private int value;
        private Node next;
        private Node rand;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node copyLinkedList1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyLinkedList2(Node head){
        if(head == null) return null;
        Node cur = head;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node nodeCopy = null;
        while (cur != null){
            next = cur.next.next;
            nodeCopy = cur.next;
            nodeCopy.rand = cur.rand != null? cur.rand.next : null;
            cur = next;
        }
        Node ret = head.next;
        cur = head;
        while (cur != null){
            next = cur.next.next;
            nodeCopy = cur.next;
            cur.next = next;
            nodeCopy.next = next != null? next.next : null;
            cur = next;
        }
        return ret;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

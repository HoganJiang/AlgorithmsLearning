package chapter06.exercise;

public class Exercise01 {

    public static class Node {
        private int value;
        private Node next;

        public Node(int item){
            this.value = item;
        }
    }

    //输入链表头节点，奇数长度返回中点，偶数长度返回上中点
    public static Node getMidOrMidLeftNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点，偶数长度返回下中点
    public static Node getMidOrMidDownNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        Node slow = head.next;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点前一个，偶数长度返回上中点前一个
    public static Node getMidPreOrUpMidPreNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head.next.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入链表头节点，奇数长度返回中点前一个，偶数长度返回下中点前一个
    public static Node getMidPreOrDownMidPreNode(Node head){
        if(head == null || head.next == null){
            return null;
        }
        if (head.next.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

package chapter06.exercise;

import java.util.Stack;

public class Exercise02 {

    public static class Node {
        private int value;
        private Node next;

        public Node(int vale){
            this.value = vale;
        }
    }

    public static boolean isPalindrome1(Node head){
        Stack<Node> s = new Stack<>();
        Node cur = head;
        while (cur != null){
            s.push(cur);
            cur = cur.next;
        }
        while (head != null){
            if(head.value != s.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head.next;
        while (slow.next != null && slow.next.next != null){
            slow = slow.next.next;
            fast = fast.next;
        }
        Stack<Node> s = new Stack<>();
        while (fast != null){
            s.push(fast);
            fast = fast.next;
        }
        while (!s.isEmpty()){
            if(head.value != s.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}

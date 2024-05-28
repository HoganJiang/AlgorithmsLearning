package chapter07.exercise;

import java.util.Stack;

public class Exercise02 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

//        pre(head);
//        System.out.println("========");
//        in(head);
//        System.out.println("========");
//        pos1(head);
//        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node (int value){
            this.value = value;
        }
    }

    public static void pre(Node head){
        if(head != null){
            Stack<Node> s = new Stack<>();
            s.push(head);
            while (!s.isEmpty()){
                head = s.pop();
                System.out.println(head.value);
                if(head.right != null){
                    s.push(head.right);
                }
                if(head.left != null){
                    s.push(head.left);
                }
            }
            System.out.println();
        }
    }

    public static void in(Node head){
        if(head != null){
            Stack<Node> s = new Stack<>();
            while (!s.isEmpty() || head != null){
                if(head != null){
                    s.push(head);
                    head = head.left;
                } else {
                    head = s.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }
    }
    public static void pos1(Node head){
        if(head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left != null){
                    s1.push(head.left);
                }
                if(head.right != null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().value);
            }
        }
    }

    public static void pos2(Node h){
        if(h != null){
            Stack<Node> s = new Stack<>();
            s.push(h);
            Node c = null;
            while(!s.isEmpty()){
                c = s.peek();
                if(c.left != null && h != c.left && h != c.right){
                    s.push(c.left);
                } else if(c.right != null && h != c.right){
                    s.push(c.right);
                } else {
                    System.out.println(s.pop().value);
                    h = c;
                }
            }
        }
    }
}

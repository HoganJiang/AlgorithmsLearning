package chapter07.exercise;


import java.util.LinkedList;
import java.util.Queue;

public class Exercise03 {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        levelTraverse(head);

    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node (int value){
            this.value = value;
        }
    }

    public static void levelTraverse(Node head){
        if(head == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(head);
        while(!q.isEmpty()){
            head = q.poll();
            System.out.println(head.value);
            if(head.left != null){
                q.add(head.left);
            }
            if(head.right != null){
                q.add(head.right);
            }
        }
    }

}

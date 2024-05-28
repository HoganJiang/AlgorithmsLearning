package chapter08.exercise;

public class Exercise06 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info{
        private int height;
        private int maxDistance;

        public Info(int height, int maxDistance){
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }

    public static int getMaxDistance(Node head){
        return process(head).maxDistance;
    }

    public static Info process(Node x){
        if(x == null) return new Info(0,0);
        Info leftTreeInfo = process(x.left);
        Info rightTreeInfo = process(x.right);
        int maxDistance = Math.max(leftTreeInfo.maxDistance, rightTreeInfo.maxDistance);
        int maxHeight = Math.max(leftTreeInfo.height,rightTreeInfo.height) + 1;
        return new Info(maxDistance,maxHeight);
    }
}

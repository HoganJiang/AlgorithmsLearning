package chapter08.exercise;

public class Exercise01 {
    public static void main(String[] args) {
        PrintBT.Node head = new PrintBT.Node(1);
        head.left = new PrintBT.Node(-222222222);
        head.right = new PrintBT.Node(3);
        head.left.left = new PrintBT.Node(Integer.MIN_VALUE);
        head.right.left = new PrintBT.Node(55555555);
        head.right.right = new PrintBT.Node(66);
        head.left.left.right = new PrintBT.Node(777);
        PrintBT.printTree(head);
    }
}

class PrintBT{

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void printTree(Node head){
        System.out.println("Begin printing tree: ");
        printBinaryTree(head,0, "H",17);
        System.out.println();
    }

    public static void printBinaryTree(Node head, int depth, String to, int len){
        if(head == null) return;
        printBinaryTree(head.right, depth + 1,"*", len);
        String value = to + head.value + to;
        int valLen = value.length();
        int leftLen = (len - valLen) / 2;
        int rightLen = len - valLen - leftLen;
        value = getSpace(leftLen) + value + getSpace(rightLen);
        System.out.println(getSpace(depth * len) + value);
        printBinaryTree(head.left,depth + 1,"*",len);
    }

    public static String getSpace(int size){
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < size; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
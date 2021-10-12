package chapter08.exercise;

/**
 * 题目：判断一棵树是否是满二叉树
 * 分析：满二叉树的性质：2^h - 1 = n
 * n - 节点数
 * h - 树的高度
 */
public class Exercise10 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isFullBT(Node head){
        Info res = process(head);
        return (1 << res.height) - 1 == res.nodes;
    }

    public static class Info {
        private int height;
        private int nodes;

        public Info(int height, int nodes){
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static Info process(Node x){
        if(x == null) return new Info(0,0);
        Info lefTreeInfo = process(x.left);
        Info rightTreeInfo = process(x.right);
        int height = Math.max(lefTreeInfo.height, rightTreeInfo.height) + 1;
        int nodes = lefTreeInfo.nodes + rightTreeInfo.nodes + 1;
        return new Info(height,nodes);
    }

}

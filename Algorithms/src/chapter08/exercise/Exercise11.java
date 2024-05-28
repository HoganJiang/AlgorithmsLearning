package chapter08.exercise;

import java.util.LinkedList;

/**
 * 题目：给定一棵二叉树的头节点head，返回这颗二叉树中是不是完全二叉树
 * 关键：明确判断一棵树是否是完全二叉树要满足两个条件
 *      1）节点的右子树不为空，但左子树为空，则肯定不是完全二叉树
 *      2）左右孩子不双全的情况下，后续节点必须是叶节点
 */
public class Exercise11 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //宽度优先遍历求解
    public static boolean isCBT1(Node head){
        if(head == null) return true;
        //leaf: 是否遇到左右节点双全的情况，默认没有遇到
        boolean leaf = false;
        Node left = null;
        Node right = null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node pollNode = queue.poll();
            left = pollNode.left;
            right = pollNode.right;
            if(leaf && (left != null || right != null)
            || (left == null && right != null)){
                return false;
            }
            if(left != null){
                queue.add(left);
            }
            if(right != null){
                queue.add(right);
            }
            if(left == null || right == null){
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 根据二叉树的递归套路来求解
     * 可能性划分标准：根据最后一层的最后一个节点到哪儿了来分类
     *  1）无缺口--所有层都是满的，没有缺口的位置 - 一棵满二叉树
     *  2）有缺口：
     *      2.1）左树是完全二叉树，右树是满二叉树，且左树的高度比右树的高度大1
     *      2.2）左树是满二叉树，右树是满二叉树，且左树的高度是比右树的高度大1
     *      2.3）左树是满二叉树，右树是完全二叉树，且左右两树的高度相等
     */
    public static boolean isCBT2(Node head){
        if(head == null) return true;
        return process(head).isCBT;
    }

    public static class Info{
        private boolean isFullBT;
        private boolean isCBT;
        private int height;

        public Info(boolean isFullBT, boolean isCBT, int height){
            this.isFullBT = isFullBT;
            this.isCBT = isCBT;
            this.height = height;
        }
    }

    public static Info process(Node x){
        if(x == null) return new Info(true,true,0);
        Info leftTreeInfo = process(x.left);
        Info rightTreeInfo = process(x.right);
        int height = Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1;
        boolean isFullBT = leftTreeInfo.isFullBT && rightTreeInfo.isFullBT && (leftTreeInfo.height == rightTreeInfo.height);
        boolean isCBT = false;
        if(isFullBT){
            isCBT = true;
        } else {
            if(leftTreeInfo.isCBT && rightTreeInfo.isCBT){
                if(leftTreeInfo.isCBT && rightTreeInfo.isFullBT && (leftTreeInfo.height == rightTreeInfo.height + 1)){
                    isCBT = true;
                }
                if(leftTreeInfo.isFullBT && rightTreeInfo.isFullBT && leftTreeInfo.height == rightTreeInfo.height + 1){
                    isCBT = true;
                }
                if(leftTreeInfo.isFullBT && rightTreeInfo.isCBT && leftTreeInfo.height == rightTreeInfo.height){
                    isCBT = true;
                }
            }
        }
        return new Info(isFullBT,isCBT,height);
    }

    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }
}

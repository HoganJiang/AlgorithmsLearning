package chapter08.exercise;

public class Exercise05 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 题目：给定一棵二叉树的头节点head，返回这颗二叉树是不是平衡二叉树
     * 分析：
     * 1）要判断一棵树是否为平衡二叉树，假定左子树和右子树能够给到所有求出答案所需得信息
     * 2）若1假设成立，求出答案的可能性有哪些：一棵树是平衡二叉树，需要满足3个条件
     *      2.1）左子树是平衡二叉树
     *      2.2）右子树是平衡二叉树
     *      2.3）两课子树的最大高度差不超过1
     * 3）基于2，分析好可能性后，需要左子树和右子树要哪些信息：
     *      3.1）记录是否平衡的变量
     *      3.2）记录树的高度的变量
     * @param x
     * @return
     */
    public static boolean isBalanceTree(Node x){
        return process(x).isBalance;
    }

    public static class Infor{
        private boolean isBalance;
        private int height;

        public Infor(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static Infor process(Node x){
        if(x == null){
            return new Infor(true,0);
        }
        Infor leftTree = process(x.left);
        Infor rightTree = process(x.right);
        int height = Math.max(leftTree.height,rightTree.height) + 1;
        boolean isBalance = true;
        if(!leftTree.isBalance || !rightTree.isBalance || Math.abs(leftTree.height - rightTree.height) > 1){
            isBalance = false;
        }
        return new Infor(isBalance,height);
    }

}

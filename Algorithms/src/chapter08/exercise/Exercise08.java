package chapter08.exercise;

/**
 * 题目：给定一棵二叉树的头节点head，返回这颗二叉树中最大的二叉搜索子树的大小
 * 分析：
 * （1）假设头节点所在树的左子树与右子树能够给到求出该问题所需要的所有信息
 * （2）求出该问题可能有哪几种情况需要考虑：
 *      2.1）该节点所在的树，不是搜索二叉树，也就是问题所求解与该节点无关
 *      2.2）该节点所在的树，是搜索二叉树，也就是问题所求解与该节点有关
 * （3）基于两种可能性，需要的信息信息：
 *      3.1）基于2.1，需要从左子树找出最大的二叉搜索子树的大小与右子树中最大二叉搜索子树的大小，然后求大值，因此所需要的信息有：是否是二叉搜索树，它的大小
 *      3.2）基于2.2，要满足节点所在的树是一棵二叉搜索树，就要满足左子树与右子树都是二叉搜索树，且左子树的最大值要小于该节点的值，右子树的最小值大于该节点的值。
 *      因此所需要的信息有：是否是二叉搜索树，二叉搜索树的最大值，左子树的最大值，右子树的最小值
 * （4）求所有所需要的信息的全集
 */
public class Exercise08 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        private boolean isBST;
        private int maxSubBSTSize;
        private int min;
        private int max;

        public Info(boolean isBST, int maxSize, int min, int max){
            this.isBST = isBST;
            this.maxSubBSTSize = maxSize;
            this.min = min;
            this.max = max;
        }
    }

    public static int getBSTSize(Node head){
        return process(head).maxSubBSTSize;
    }

    public static Info process(Node x){
        if(x == null) return null;
        Info leftTreeInfo = process(x.left);
        Info rightTreeInfo = process(x.right);

        int min = x.value;
        int max = x.value;
        if(leftTreeInfo != null){
            min = Math.min(min,leftTreeInfo.min);
            max = Math.max(max,leftTreeInfo.max);
        }
        if(rightTreeInfo != null){
            min = Math.min(min, rightTreeInfo.min);
            max = Math.max(max, rightTreeInfo.max);
        }

        int maxSubBSTSize = 0;
        if(leftTreeInfo != null){
            maxSubBSTSize = leftTreeInfo.maxSubBSTSize;
        }
        if(rightTreeInfo != null){
            maxSubBSTSize = Math.max(leftTreeInfo.maxSubBSTSize, rightTreeInfo.maxSubBSTSize);
        }

        boolean isBST = false;
        if((leftTreeInfo == null? true : leftTreeInfo.isBST)
            && (rightTreeInfo == null? true : rightTreeInfo.isBST)
            && (leftTreeInfo == null? true : (leftTreeInfo.max < x.value))
            && (rightTreeInfo == null? true: (rightTreeInfo.min > x.value))){
            isBST = true;
            maxSubBSTSize = (leftTreeInfo == null? 0 : leftTreeInfo.maxSubBSTSize)
                            + (rightTreeInfo == null? 0: rightTreeInfo.maxSubBSTSize)
                            + 1;
        }
        return new Info(isBST,maxSubBSTSize,min,max);
    }


}

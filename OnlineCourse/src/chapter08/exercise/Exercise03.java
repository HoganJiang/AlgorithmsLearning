package chapter08.exercise;

public class Exercise03 {
    public static void main(String[] args) {
        Precursor.Node head = new Precursor.Node(6);
        head.parent = null;
        head.left = new Precursor.Node(3);
        head.left.parent = head;
        head.left.left = new Precursor.Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Precursor.Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Precursor.Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Precursor.Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Precursor.Node(9);
        head.right.parent = head;
        head.right.left = new Precursor.Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Precursor.Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Precursor.Node(10);
        head.right.right.parent = head.right;

        Precursor.Node test = head.left.left;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test));
        test = head.left.left.right;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.left;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.left.right;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.right.left;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.right;
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);
        test = head.right.right; // 10's pre is null
        System.out.println(test.value + " pre: " + Precursor.getPrecursor(test).value);

    }


}


class Precursor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
            this.value = data;
        }
    }

    //按照中序遍历的方式找出任意节点的后继节点

    /**
     * 1）若某个节点的左子树不为空，则该左子树的最右的端的节点是前驱节点
     * 2）若某个节点的左子树为空，则沿着父节点往上找，当遇到的节点是其父节点的右孩子时，则该父节点为开始的节点的前驱节点
     * 3）整棵树的最左节点是null
     * @param node
     * @return
     */
    public static Node getPrecursor(Node node){

        if(node == null) return null;

        if(node.left != null){
            return getRightNodeMost(node);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left == node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getRightNodeMost(Node node){

        if(node == null){
            return node;
        }

        while (node.right != null){
            node = node.right;
        }

        return node;
    }

}
package chapter08.exercise;

public class Exercise02 {
    public static void main(String[] args) {
        SuccessorNode.Node head = new SuccessorNode.Node(6);
        head.parent = null;
        head.left = new SuccessorNode.Node(3);
        head.left.parent = head;
        head.left.left = new SuccessorNode.Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new SuccessorNode.Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new SuccessorNode.Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new SuccessorNode.Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new SuccessorNode.Node(9);
        head.right.parent = head;
        head.right.left = new SuccessorNode.Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new SuccessorNode.Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new SuccessorNode.Node(10);
        head.right.right.parent = head.right;

        SuccessorNode.Node test = head.left.left;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + SuccessorNode.getSuccessorNode(test));

    }
}

class SuccessorNode {

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
     * 1）若某个节点的右子树不为空，则该右子树的最左的端的节点是后继节点
     * 2）若某个节点的右子树为空，则沿着父节点往上找，当遇到的节点是其父节点的左孩子时，则该父节点为开始的节点的后继节点
     * 3）整棵树的最右节点是null
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node){

        if(node == null) return null;

        if(node.right != null){
            return getLeftNodeMost(node);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.right == node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftNodeMost(Node node){

        if(node == null){
            return node;
        }

        while (node.left != null){
            node = node.left;
        }

        return node;
    }

}

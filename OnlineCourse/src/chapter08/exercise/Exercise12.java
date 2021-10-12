package chapter08.exercise;

import java.util.HashMap;
import java.util.HashSet;

public class Exercise12 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lowestPublicAncestor1(Node head, Node a, Node b){
        if(head == null) return null;
        HashMap<Node,Node> parentMap = new HashMap<>();
        parentMap.put(head,null);
        fillParentMap(head,parentMap);
        HashSet<Node> set = new HashSet<>();
        Node cur = a;
        set.add(cur);
        while(parentMap.get(cur) != null){
            cur = parentMap.get(a);
            set.add(cur);
        }
        cur = b;
        while(!set.contains(cur)){
            cur = parentMap.get(cur);
        }
        return cur;
    }

    public static void fillParentMap(Node head, HashMap<Node,Node> parentMap){
        if(head.left != null){
            parentMap.put(head.left, head);
            fillParentMap(head.left,parentMap);
        }
        if(head.right != null){
            parentMap.put(head.right,head);
            fillParentMap(head.right,parentMap);
        }
    }

    public static Node lowestPublicAncestor2(Node head, Node o1, Node o2){
        if(head == null);
        return process(head, o1, o2).ans;
    }

    public static class Info {
        private Node ans;
        private boolean findO1;
        private boolean findO2;

        public Info(Node ans, boolean findO1, boolean findO2){
            this.ans = ans;
            this.findO1 = findO1;
            this.findO2 = findO2;
        }
    }

    public static Info process(Node x, Node o1, Node o2){
        if(x == null) return new Info(null, false, false);
        Info leftTree = process(x.left, o1, o2);
        Info rightTree = process(x.right, o1, o2);
        boolean findO1 = x == o1 || leftTree.findO1 || rightTree.findO1;
        boolean find02 = x == o2 || leftTree.findO2 || rightTree.findO2;
        Node ans = null;
        if(leftTree.ans != null){
            ans = leftTree.ans;
        }
        if(rightTree.ans != null){
            ans = rightTree.ans;
        }
        if(ans == null){
            if(findO1 == find02){
                ans = x;
            }
        }
        return new Info(ans, findO1,find02);
    }

}

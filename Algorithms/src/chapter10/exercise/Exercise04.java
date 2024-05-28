package chapter10.exercise;

import java.util.HashSet;
import java.util.Stack;

public class Exercise04 {

    public static void dfs(Node node){
        if(node == null) return;
        Stack<Node> nodeStack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        nodeStack.push(node);
        set.add(node);
        System.out.print(node.id + " ");
        while(!nodeStack.isEmpty()){
            Node cur = nodeStack.pop();
            for(Node next : cur.next){
                if(!set.contains(next)){
                    nodeStack.push(cur);
                    nodeStack.push(next);
                    set.add(next);
                    System.out.print(next.id + " ");
                    break;
                }
            }
        }

    }

}

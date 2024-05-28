package chapter10.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Exercise03 {

    public static void bfs(Node node){
        if(node == null) return;
        Queue<Node> nodeQueue = new LinkedList<>();
        HashSet<Node> nodeSet = new HashSet<>();
        nodeQueue.add(node);
        nodeSet.add(node);
        while(!nodeQueue.isEmpty()){
            Node pollNode = nodeQueue.poll();
            System.out.print(pollNode.id + " ");
            for(Node cur : pollNode.next){
                if(!nodeSet.contains(cur)){
                    nodeQueue.add(cur);
                    nodeSet.add(cur);
                }
            }
        }
    }

}

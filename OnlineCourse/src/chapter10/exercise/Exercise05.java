package chapter10.exercise;

import java.util.*;

public class Exercise05 {

    public List<Node> sortedTopology(Graph graph){

        //记录节点剩余的入度
        HashMap<Node,Integer> inMap = new HashMap<>();
        //记录节点入度为0
        Queue<Node> zeroQueue = new LinkedList<>();

        for(Node cur : graph.nodes.values()){
            inMap.put(cur, cur.in);
            if(cur.in == 0){
                zeroQueue.add(cur);
            }
        }

        List<Node> res = new ArrayList<>();
        while (!zeroQueue.isEmpty()){
            Node zeroInNode = zeroQueue.poll();
            res.add(zeroInNode);
            for(Node next : zeroInNode.next){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroQueue.add(next);
                }
            }
        }
        return res;
    }

}

package chapter10.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Exercise08 {

    public static HashMap<Node,Integer> dijkstra(Node k){
        HashMap<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(k,0);
        HashSet<Node> selectedNodeSet = new HashSet<>();
        Node minNode = getMinNodeAndUnselectNodes(distanceMap,selectedNodeSet);
        while(minNode != null) {
            Integer distance = distanceMap.get(minNode);
            for (Edge next : minNode.edge) {
                Node toNode = next.to;
                if(!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance + next.weight);
                } else {
                    distanceMap.put(toNode,Math.min(distanceMap.get(toNode),distance + next.weight));
                }
            }
            selectedNodeSet.add(minNode);
            minNode = getMinNodeAndUnselectNodes(distanceMap,selectedNodeSet);
        }
        return distanceMap;
    }

    public static Node getMinNodeAndUnselectNodes(HashMap<Node,Integer> distanceMap, HashSet<Node> selectedNodeSet){
        Node minNode = null;
        Integer minInstance = Integer.MIN_VALUE;
        for(Map.Entry<Node, Integer> entry : distanceMap.entrySet()){
            Node key = entry.getKey();
            Integer distance = entry.getValue();
            if(!selectedNodeSet.contains(key) && distance < minInstance){
                minNode = key;
                minInstance = distance;
            }
        }
        return minNode;
    }

}

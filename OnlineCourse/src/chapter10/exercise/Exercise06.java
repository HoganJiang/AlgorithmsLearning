package chapter10.exercise;

import java.util.*;

public class Exercise06 {

    public static class UnionSet {
        private HashMap<Node,Node> fatherMap;
        private HashMap<Node,Integer> mapSize;

        public UnionSet(){
            this.fatherMap = new HashMap<>();
            this.mapSize = new HashMap<>();
        }

        public void generateUnionSet(Collection<Node> nodes){
            fatherMap.clear();
            mapSize.clear();
            for(Node cur : nodes){
                fatherMap.put(cur,cur);
                mapSize.put(cur,1);
            }
        }

        private Node findFather(Node k){
            if(k == null) return null;
            Stack<Node> path = new Stack<>();
            while(k != fatherMap.get(k)){
                k = fatherMap.get(k);
            }
            while(!path.isEmpty()){
                fatherMap.put(path.pop(),k);
            }
            return k;
        }

        public boolean isSameSet(Node a, Node b){
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b){
            if(a == null || b == null) return;
            Node aHead = findFather(a);
            Node bHead = findFather(b);
            if(aHead != bHead){
                Integer aSetSize = mapSize.get(aHead);
                Integer bSetSize = mapSize.get(bHead);
                Node bigNode = aSetSize >= bSetSize? aHead : bHead;
                Node smallNode = bigNode == aHead ? bHead : aHead;
                fatherMap.put(smallNode,bigNode);
                mapSize.put(bigNode,mapSize.get(bigNode) + 1);
                mapSize.remove(smallNode);
            }
        }
    }

    private class weightComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public Set<Edge> kruskalMST(Graph graph){
        UnionSet unionSet = new UnionSet();
        unionSet.generateUnionSet(graph.nodes.values());
        PriorityQueue<Edge> edges = new PriorityQueue<>(new weightComparator());
        for(Edge edge : edges){
            edges.add(edge);
        }
        HashSet<Edge> result = new HashSet<>();
        while (!edges.isEmpty()){
            Edge pollEdge = edges.poll();
            if(!unionSet.isSameSet(pollEdge.from,pollEdge.to)){
                result.add(pollEdge);
                unionSet.union(pollEdge.from,pollEdge.to);
            }
        }
        return result;
    }
}
